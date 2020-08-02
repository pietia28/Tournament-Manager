package pl.pg.tmanager.match;

import lombok.Data;
import pl.pg.tmanager.matchevents.matchevent.MatchEvent;
import pl.pg.tmanager.refeere.Refeere;
import pl.pg.tmanager.stadium.Stadium;
import pl.pg.tmanager.team.Team;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "match_day")
    private Integer matchDay;

    @NotNull
    @Column(name = "match_date")
    private LocalDateTime matchDate;

    @NotNull
    private LocalTime start;

    private LocalTime end;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "refeere_id")
    private Refeere refeere;

    @ManyToMany
    private List<MatchEvent> matchEvents;

    @ManyToMany
    private List<Team> teams;

    public Match() {
        //JPA Only
    }
}
