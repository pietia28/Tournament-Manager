package pl.pg.tmanager.referee;

import pl.pg.tmanager.user.UserDtoMapper;

public class RefereeDtoMapper {
    private RefereeDtoMapper() {
    }

    public static Referee DtoToEntity(RefereeDto refereeDto) {
        return new Referee().setId(refereeDto.getId())
                .setUser(UserDtoMapper.DtoToEntity(refereeDto.getUser()));
    }

    public static RefereeDto EntityToDto(Referee referee) {
        return new RefereeDto().setId(referee.getId())
                .setUser(UserDtoMapper.EntityToDto(referee.getUser()));
    }

}
