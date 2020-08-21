package pl.pg.tmanager.user;

public class UserDtoMapper {
    private UserDtoMapper() {
    }
    public static User DtoToEntityUpdate(UserDtoUpdate userDtoUpdate) {
        return new User().setId(userDtoUpdate.getId())
                .setFirstName(userDtoUpdate.getFirstName().trim())
                .setLastName(userDtoUpdate.getLastName().trim())
                .setEmail(userDtoUpdate.getEmail().trim())
                .setNick(userDtoUpdate.getNick().trim())
                .setMobile(userDtoUpdate.getMobile().trim())
                .setPassword(userDtoUpdate.getPassword());
    }

    public static UserDtoUpdate EntityToDtoUpdate(User user) {
        return new UserDtoUpdate().setId(user.getId())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setNick(user.getNick())
                .setMobile(user.getMobile());
                /*.setRole(user.getRole().stream()
                        .map(RoleDtoMapper::EntityToDto)
                        .collect(Collectors.toList())
                );*/
    }

    public static User DtoToEntityCreate(UserDtoCreate userDtoCreate) {
        return new User().setId(userDtoCreate.getId())
                .setEmail(userDtoCreate.getEmail().trim())
                .setFirstName(userDtoCreate.getFirstName().trim())
                .setLastName(userDtoCreate.getLastName().trim())
                .setNick(userDtoCreate.getNick().trim())
                .setMobile(userDtoCreate.getMobile().trim())
                .setPassword(userDtoCreate.getPassword().trim());
                /*.setRole(userDto.getRole().stream()
                        .map(RoleDtoMapper::DtoToEntity)
                        .collect(Collectors.toList())
                );*/
    }

    public static User DtoToEntity(UserDto userDto) {
        return new User().setId(userDto.getId())
                .setEmail(userDto.getEmail().trim())
                .setFirstName(userDto.getFirstName().trim())
                .setLastName(userDto.getLastName().trim())
                .setNick(userDto.getNick().trim())
                .setMobile(userDto.getMobile().trim());
                /*.setRole(userDto.getRole().stream()
                        .map(RoleDtoMapper::DtoToEntity)
                        .collect(Collectors.toList())
                );*/
    }

    public static UserDto EntityToDto(User user) {
        return new UserDto().setId(user.getId())
                .setEmail(user.getEmail().trim())
                .setFirstName(user.getFirstName().trim())
                .setLastName(user.getLastName().trim())
                .setNick(user.getNick().trim())
                .setMobile(user.getMobile().trim());
                /*.setRole(user.getRole().stream()
                        .map(RoleDtoMapper::EntityToDto)
                        .collect(Collectors.toList())
                );*/
    }
}
//TODO pododawać TRIM