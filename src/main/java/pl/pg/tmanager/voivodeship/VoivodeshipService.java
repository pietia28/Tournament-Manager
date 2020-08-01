package pl.pg.tmanager.voivodeship;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.dtoMapping.dtoconvert.DtoConverter;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.message.MessagesHandler;
import pl.pg.tmanager.user.UserNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@RequiredArgsConstructor
@Slf4j
@Service
public class VoivodeshipService {
    private final VoivodeshipRepository voivodeshipRepository;
    private final Validator validator;
    private final MessagesHandler<Voivodeship> messagesHandler;
    private final DtoConverter<Voivodeship> dtoConverter;
    private Map<String, Object> response;

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

    public List<Map<String, Object>> findAll() {
        return dtoConverter.EntityToDtoAll(voivodeshipRepository.findAll());
    }

    public Map<String, Object> findById(Long id) {
        Optional<Voivodeship> optionalVoivodeship = voivodeshipRepository.findById(id);
        return optionalVoivodeship
                .map(dtoConverter::EntityToDto)
                .orElseThrow(() -> new VoivodeshipNotFoundException(Message.NOT_FOUND));
    }

    public Map<String, Object> delete(Long id) {
        response = new HashMap<>();
        Optional<Voivodeship> optionalVoivodeship = voivodeshipRepository.findById(id);
        voivodeshipRepository.delete(
                optionalVoivodeship.orElseThrow(() -> new UserNotFoundException(Message.NOT_FOUND)));
        response.put(Message.STATUS, Message.OK);
        return response;
    }

    public Long count() {
        return voivodeshipRepository.count();
    }
}
