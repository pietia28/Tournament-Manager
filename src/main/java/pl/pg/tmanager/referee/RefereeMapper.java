package pl.pg.tmanager.referee;

import pl.pg.tmanager.user.UserMapper;

public class RefereeMapper {
    private RefereeMapper() {
    }

    public static Referee DtoToEntity(RefereeDto refereeDto) {
        return new Referee().setId(refereeDto.getId())
                .setUser(UserMapper.DtoToEntity(refereeDto.getUser()));
    }

    public static RefereeDto EntityToDto(Referee referee) {
        return new RefereeDto().setId(referee.getId())
                .setUser(UserMapper.EntityToDto(referee.getUser()));
    }

}
