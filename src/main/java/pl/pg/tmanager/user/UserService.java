package pl.pg.tmanager.user;

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
public class UserService implements CrudDtoMapping<User> {
    private final UserRepository userRepository;
    private final Validator validator;
    private final MessagesHandler<User> messagesHandler;
    private final DtoConverter<User> dtoConverter;
    private Map<String, Object> response;

    public UserService(UserRepository userRepository, Validator validator,
                       MessagesHandler<User> messagesHandler, DtoConverter<User> dtoConverter) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.messagesHandler = messagesHandler;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public Map<String, Object> save(User user) {
        response = new HashMap<>();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            Map<String, List<String>> errors;
            errors = messagesHandler.getValidationMessage(validator, user);
            response.put(Message.STATUS, Message.VALIDATION_ERROR + errors);
        } else {
            userRepository.save(dtoConverter.DtoToEntity(user, new User()));
            response.put(Message.STATUS, Message.OK);
        }
        return response;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return dtoConverter.EntityToDtoAll(userRepository.findAll());
    }

    @Override
    public Map<String, Object> findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional
                .map(dtoConverter::EntityToDto)
                .orElseThrow(() -> new UserNotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Map<String, Object> delete(Long id) {
        response = new HashMap<>();
        Optional<User> userOptional = userRepository.findById(id);
        userRepository.delete(
                userOptional.orElseThrow(() -> new UserNotFoundException(Message.NOT_FOUND)));
        response.put(Message.STATUS, Message.OK);
        return response;
    }

    @Override
    public Long count() {
        return userRepository.count();
    }
}
//TODO rozwiązać sprawę walidacji password przy update user
//TODO stworzyć kaskady
