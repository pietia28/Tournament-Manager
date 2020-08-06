package pl.pg.tmanager.match;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.integration.weather.accuweather.WeatherDto;
import pl.pg.tmanager.matchevents.matchevent.MatchEventDto;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.referee.RefereeDto;
import pl.pg.tmanager.stadium.StadiumDto;
import pl.pg.tmanager.team.TeamDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class MatchDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    private Integer matchDay;

    @NotNull(message = Message.VALID_NOT_NULL)
    private LocalDateTime matchDate;

    @NotNull(message = Message.VALID_NOT_NULL)
    private LocalTime start;

    private LocalTime end;

    @NotNull(message = Message.VALID_NOT_NULL)
    private StadiumDto stadium;

    @NotNull(message = Message.VALID_NOT_NULL)
    private RefereeDto referee;

    private List<MatchEventDto> matchEvents;

    @NotNull(message = Message.VALID_NOT_NULL)
    private List<TeamDto> teams;

    private WeatherDto weather;
}
