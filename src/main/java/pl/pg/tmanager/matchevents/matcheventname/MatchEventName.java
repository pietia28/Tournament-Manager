package pl.pg.tmanager.matchevents.matcheventname;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "events_names")
public class MatchEventName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    public MatchEventName() {
        //JPA Only
    }
}
