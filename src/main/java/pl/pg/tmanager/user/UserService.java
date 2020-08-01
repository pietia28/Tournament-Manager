package pl.pg.tmanager.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.dtoMapping.dtoconvert.DtoConverter;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.message.MessagesHandler;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final Validator validator;
    private final MessagesHandler<User> messagesHandler;
    private final DtoConverter<User> dtoConverter;
    private Map<String, Object> response;

    public Map<String, Object> save(User user) {
        response = new HashMap<>();
        User entityUser = null;
        if (user.id != null) {
            Optional<User> userOptional = userRepository.findById(user.id);
            entityUser = userOptional.
                    orElseThrow(() -> new UserNotFoundException(Message.NOT_FOUND));
        }
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            Map<String, List<String>> errors;
            errors = messagesHandler.getValidationMessage(validator, user);
            response.put(Message.STATUS, Message.VALIDATION_ERROR + errors);
        } else {
            userRepository.save(dtoConverter.DtoToEntity(user, entityUser));
            response.put(Message.STATUS, Message.OK);
        }
        return response;
    }

    public List<Map<String, Object>> findAll() {
        return dtoConverter.EntityToDtoAll(userRepository.findAll());
    }

    public Map<String, Object> findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional
                .map(dtoConverter::EntityToDto)
                .orElseThrow(() -> new UserNotFoundException(Message.NOT_FOUND));
    }

    public Map<String, Object> delete(Long id) {
        response = new HashMap<>();
        Optional<User> userOptional = userRepository.findById(id);
        userRepository.delete(
                userOptional.orElseThrow(() -> new UserNotFoundException(Message.NOT_FOUND)));
        response.put(Message.STATUS, Message.OK);
        return response;
    }

    public Long count() {
        return userRepository.count();
    }
}
//TODO rozwiązać sprawę walidacji password przy update user
//TODO stworzyć kaskady
