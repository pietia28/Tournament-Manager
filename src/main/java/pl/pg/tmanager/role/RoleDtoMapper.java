package pl.pg.tmanager.role;

public class RoleDtoMapper {
    private RoleDtoMapper() {
    }

    public static Role DtoToEntity(RoleDto roleDto) {
        return new Role().setId(roleDto.getId())
                .setName(roleDto.getName());
    }

    public static RoleDto EntityToDto(Role role) {
        return new RoleDto().setId(role.getId())
                .setName(role.getName());
    }
}
