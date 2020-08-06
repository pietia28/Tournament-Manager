package pl.pg.tmanager.match;
import pl.pg.tmanager.integration.weather.accuweather.WeatherDto;
import pl.pg.tmanager.integration.weather.accuweather.WeatherDtoMapper;
import pl.pg.tmanager.matchevents.matchevent.MatchEventDtoMapper;
import pl.pg.tmanager.referee.RefereeDtoMapper;
import pl.pg.tmanager.stadium.StadiumDtoMapper;
import pl.pg.tmanager.team.TeamDtoMapper;
import java.util.stream.Collectors;

public class MatchDtoMapper {
    private MatchDtoMapper() {
    }

    public static Match DtoToEntity(MatchDto matchDto) {
        return new Match().setId(matchDto.getId())
                .setEnd(matchDto.getEnd())
                .setMatchDate(matchDto.getMatchDate())
                .setMatchDay(matchDto.getMatchDay())
                .setMatchEvents(matchDto.getMatchEvents().stream()
                        .map(MatchEventDtoMapper::DtoToEntity)
                        .collect(Collectors.toList()))
                .setStadium(StadiumDtoMapper.DtoToEntity(matchDto.getStadium()))
                .setReferee(RefereeDtoMapper.DtoToEntity(matchDto.getReferee()))
                .setStart(matchDto.getStart())
                .setTeams(matchDto.getTeams().stream()
                        .map((TeamDtoMapper::DtoToEntity))
                        .collect(Collectors.toList()))
                .setWeather(WeatherDtoMapper.DtoToEntity(matchDto.getWeather()));
    }
    public static MatchDto EntityToDto(Match match) {
        return new MatchDto().setId(match.getId())
                .setEnd(match.getEnd())
                .setMatchDate(match.getMatchDate())
                .setMatchDay(match.getMatchDay())
                .setMatchEvents(match.getMatchEvents().stream()
                        .map(MatchEventDtoMapper::EntityToDto)
                        .collect(Collectors.toList()))
                .setReferee(RefereeDtoMapper.EntityToDto(match.getReferee()))
                .setStadium(StadiumDtoMapper.EntityToDto(match.getStadium()))
                .setStart(match.getStart())
                .setTeams(match.getTeams().stream()
                        .map(TeamDtoMapper::EntityToDto)
                        .collect(Collectors.toList()))
                .setWeather(WeatherDtoMapper.EntityToDto(match.getWeather()));
    }
}
