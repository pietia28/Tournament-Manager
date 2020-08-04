package pl.pg.tmanager.match;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.integration.weather.accuweather.Weather;
import pl.pg.tmanager.matchevents.matchevent.MatchEvent;
import pl.pg.tmanager.referee.RefereeDto;
import pl.pg.tmanager.stadium.StadiumDto;
import pl.pg.tmanager.team.Team;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class MatchDto {
    private Long id;

    @NotNull
    private Integer matchDay;

    @NotNull
    private LocalDateTime matchDate;

    @NotNull
    private LocalTime start;

    private LocalTime end;

    @NotNull
    private StadiumDto stadium;

    @NotNull
    private RefereeDto referee;

    private List<MatchEvent> matchEvents;

    @NotNull
    private List<Team> teams;

    private Weather weather;
}
