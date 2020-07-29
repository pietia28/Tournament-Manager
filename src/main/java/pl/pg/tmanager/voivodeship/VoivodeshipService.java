package pl.pg.tmanager.voivodeship;

import org.springframework.stereotype.Service;
import pl.pg.tmanager.dtoMapping.dtoconvert.DtoConverter;
import pl.pg.tmanager.interfaces.CrudDtoMapping;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.message.MessagesHandler;
import pl.pg.tmanager.user.UserNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@Service
public class VoivodeshipService implements CrudDtoMapping<Voivodeship> {
    private final VoivodeshipRepository voivodeshipRepository;
    private final Validator validator;
    private final MessagesHandler<Voivodeship> messagesHandler;
    private final DtoConverter<Voivodeship> dtoConverter;
    private Map<String, Object> response;

    public VoivodeshipService(VoivodeshipRepository voivodeshipRepository, Validator validator,
                              MessagesHandler<Voivodeship> messagesHandler,
                              DtoConverter<Voivodeship> dtoConverter) {
        this.voivodeshipRepository = voivodeshipRepository;
        this.validator = validator;
        this.messagesHandler = messagesHandler;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public Map<String, Object> save(Voivodeship voivodeship) {
        response = new HashMap<>();
        Set<ConstraintViolation<Voivodeship>> violations = validator.validate(voivodeship);
        if (!violations.isEmpty()) {
            Map<String, List<String>> errors;
            errors = messagesHandler.getValidationMessage(validator, voivodeship);
            response.put(Message.STATUS, Message.VALIDATION_ERROR + errors);
        } else {
            voivodeshipRepository.save(dtoConverter.DtoToEntity(voivodeship, new Voivodeship()));
            response.put(Message.STATUS, Message.OK);
        }
        return response;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return dtoConverter.EntityToDtoAll(voivodeshipRepository.findAll());
    }

    @Override
    public Map<String, Object> findById(Long id) {
        Optional<Voivodeship> optionalVoivodeship = voivodeshipRepository.findById(id);
        return optionalVoivodeship
                .map(dtoConverter::EntityToDto)
                .orElseThrow(() -> new VoivodeshipNotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Map<String, Object> delete(Long id) {
        response = new HashMap<>();
        Optional<Voivodeship> optionalVoivodeship = voivodeshipRepository.findById(id);
        voivodeshipRepository.delete(
                optionalVoivodeship.orElseThrow(() -> new UserNotFoundException(Message.NOT_FOUND)));
        response.put(Message.STATUS, Message.OK);
        return response;
    }

    @Override
    public Long count() {
        return voivodeshipRepository.count();
    }
}
