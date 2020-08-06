package pl.pg.tmanager.matchevents.matchevent;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.matchevents.matcheventname.MatchEventName;
import pl.pg.tmanager.player.Player;
import javax.persistence.*;
import java.time.LocalTime;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "events")
public class MatchEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
