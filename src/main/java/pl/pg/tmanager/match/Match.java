package pl.pg.tmanager.match;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.integration.weather.accuweather.Weather;
import pl.pg.tmanager.matchevents.matchevent.MatchEvent;
import pl.pg.tmanager.referee.Referee;
import pl.pg.tmanager.stadium.Stadium;
import pl.pg.tmanager.team.Team;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "match_day")
    private Integer matchDay;

    @Column(name = "match_date")
    private LocalDateTime matchDate;

    private LocalTime start;

    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;

    @ManyToOne
    @JoinColumn(name = "weather_id")
    private Weather weather;

    @ManyToMany
    private List<MatchEvent> matchEvents;

    @ManyToMany
    private List<Team> teams;

    public Match() {
        //JPA Only
    }
}
//TODO Zminic matchDate na LocalDate
//TODO Dodać pole gospodarza spotkania (hosta)
