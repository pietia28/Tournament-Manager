package pl.pg.tmanager.user;

import pl.pg.tmanager.role.RoleDtoMapper;
import java.util.stream.Collectors;

public class UserDtoMapper {
    private UserDtoMapper() {
    }

    public static User DtoToEntity(UserDto userDto) {
        return new User().setId(userDto.getId())
                .setEmail(userDto.getEmail())
                .setFirstName(userDto.getFirtstName())
                .setLastName(userDto.getLastName())
                .setNick(userDto.getNick())
                .setRole(userDto.getRole().stream()
                        .map(RoleDtoMapper::DtoToEntity)
                        .collect(Collectors.toList())
                );
    }

    public static UserDto EntityToDto(User user) {
        return new UserDto().setId(user.getId())
                .setEmail(user.getEmail())
                .setFirtstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setNick(user.getNick())
                .setRole(user.getRole().stream()
                        .map(RoleDtoMapper::EntityToDto)
                        .collect(Collectors.toList())
                );
    }
}
