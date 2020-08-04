package pl.pg.tmanager.user;

import pl.pg.tmanager.role.RoleMapper;
import java.util.stream.Collectors;

public class UserMapper {
    private UserMapper() {
    }

    public static User DtoToEntity(UserDto userDto) {
        return new User().setId(userDto.getId())
                .setEmail(userDto.getEmail())
                .setFirstName(userDto.getFirtstName())
                .setLastName(userDto.getLastName())
                .setNick(userDto.getNick())
                .setRole(userDto.getRole().stream()
                        .map(r -> RoleMapper.DtoToEntity(r))
                        .collect(Collectors.toList())
                );
    }

    public static UserDto EntityToDto(User user) {
        return new UserDto().setId(user.id)
                .setEmail(user.getEmail())
                .setFirtstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setNick(user.getNick())
                .setRole(user.getRole().stream()
                        .map(r -> RoleMapper.EntityToDto(r))
                        .collect(Collectors.toList())
                );
    }
}
