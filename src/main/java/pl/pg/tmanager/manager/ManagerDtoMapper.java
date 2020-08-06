package pl.pg.tmanager.manager;

import pl.pg.tmanager.user.UserDtoMapper;

public class ManagerDtoMapper {
    private ManagerDtoMapper() {
    }

    public static Manager DtoToEntity(ManagerDto managerDto) {
        return new Manager().setId(managerDto.getId())
                .setUser(UserDtoMapper.DtoToEntity(managerDto.getUser()));
    }

    public static ManagerDto EntityToDto(Manager manager) {
        return new ManagerDto().setId(manager.getId())
                .setUser(UserDtoMapper.EntityToDto(manager.getUser()));
    }
}
