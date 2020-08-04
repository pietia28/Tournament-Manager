package pl.pg.tmanager.role;

public class RoleMapper {
    private RoleMapper() {
    }

    public static Role DtoToEntity(RoleDto roleDto) {
        return new Role().setId(roleDto.getId());
    }

    public static RoleDto EntityToDto(Role role) {
        return new RoleDto().setId(role.getId())
                .setName(role.getName());
    }
}
