package pl.pg.tmanager.match;
import pl.pg.tmanager.referee.RefereeMapper;
import pl.pg.tmanager.stadium.StadiumMapper;

public class MatchMapper {
    private MatchMapper() {
    }

    public static Match DtoToEntity(MatchDto matchDto) {
        return new Match().setId(matchDto.getId())
                .setEnd(matchDto.getEnd())
                .setMatchDate(matchDto.getMatchDate())
                .setMatchDay(matchDto.getMatchDay())
                .setMatchEvents(matchDto.getMatchEvents())
                .setStadium(StadiumMapper.DtoToEntity(matchDto.getStadium()))
                .setReferee(RefereeMapper.DtoToEntity(matchDto.getReferee()))
                .setStart(matchDto.getStart())
                .setTeams(matchDto.getTeams())
                .setWeather(matchDto.getWeather());
    }
    public static MatchDto EntityToDto(Match match) {
        return new MatchDto().setId(match.getId())
                .setEnd(match.getEnd())
                .setMatchDate(match.getMatchDate())
                .setMatchDay(match.getMatchDay())
                .setMatchEvents(match.getMatchEvents())
                .setReferee(RefereeMapper.EntityToDto(match.getReferee()))
                .setStadium(StadiumMapper.EntityToDto(match.getStadium()))
                .setStart(match.getStart())
                .setTeams(match.getTeams())
                .setWeather(match.getWeather());
    }
}
