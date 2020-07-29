package pl.pg.tmanager.role;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.dtoMapping.dtoconvert.DtoConverter;
import pl.pg.tmanager.interfaces.CrudDtoMapping;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.message.MessagesHandler;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@Slf4j
@Service
public class RoleService implements CrudDtoMapping<Role> {

    private final RoleRepository roleRepository;
    private final Validator validator;
    private final MessagesHandler<Role> messagesHandler;
    private final DtoConverter<Role> dtoConverter;
    private Map<String, Object> response;

    public RoleService(RoleRepository roleRepository, Validator validator,
                       MessagesHandler<Role> messagesHandler, DtoConverter<Role> dtoConverter) {
        this.roleRepository = roleRepository;
        this.validator = validator;
        this.messagesHandler = messagesHandler;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public Map<String, Object> save(Role role) {
        response = new HashMap<>();
        Set<ConstraintViolation<Role>> violations = validator.validate(role);
        if (!violations.isEmpty()) {
            Map<String, List<String>> errors;
            errors = messagesHandler.getValidationMessage(validator, role);
            response.put(Message.STATUS, Message.VALIDATION_ERROR + errors);
        } else {
            roleRepository.save(dtoConverter.DtoToEntity(role, new Role()));
            response.put(Message.STATUS, Message.OK);
        }
        return response;
    }

    @Override
    public List<Map<String, Object>> findAll() {

        return dtoConverter.EntityToDtoAll(roleRepository.findAll());
    }

    @Override
    public Map<String, Object> findById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole
                .map(dtoConverter::EntityToDto)
                .orElseThrow(() -> new RoleNotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Map<String, Object> delete(Long id) {
        response = new HashMap<>();
        Optional<Role> optionalRole = roleRepository.findById(id);
        roleRepository.delete(
                optionalRole.orElseThrow(() -> new RoleNotFoundException(Message.NOT_FOUND)));
        response.put(Message.STATUS, Message.OK);
        return response;
    }

    @Override
    public Long count() {
        return roleRepository.count();
    }

}
