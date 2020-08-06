package pl.pg.tmanager.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public UserDto findById(Long id) {
        return UserDtoMapper.EntityToDto(
                userRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.USER_NOT_FOUND + id)))
        );
    }

    public User save(UserDto userDto) {
        return userRepository.save(UserDtoMapper.DtoToEntity(userDto));
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.USER_NOT_FOUND + id)));
        userRepository.deleteById(user.getId());
    }

    public Long count() {
        return userRepository.count();
    }
}
//TODO rozwiązać sprawę walidacji password przy update user
//TODO stworzyć kaskady
