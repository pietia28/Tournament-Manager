package pl.pg.tmanager.matchevents.matcheventname;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "events_names")
public class MatchEventName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Size(max = 30)
    @Column(length = 30)
    private String name;

    public MatchEventName() {
        //JPA Only
    }
}
