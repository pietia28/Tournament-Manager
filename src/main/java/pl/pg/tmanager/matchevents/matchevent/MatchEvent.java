package pl.pg.tmanager.matchevents.matchevent;

import lombok.Data;
import pl.pg.tmanager.matchevents.matcheventname.MatchEventName;
import pl.pg.tmanager.player.Player;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "events")
public class MatchEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "event_name_id")
    private MatchEventName matchEventName;

    public MatchEvent() {
        //JPA Only
    }
}
