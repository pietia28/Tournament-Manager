package pl.pg.tmanager.tournament;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.match.Match;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, unique = true)
    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    private String description;

    @ManyToMany
    private List<Match> matches;

    public Tournament() {
        //JPA Only
    }
}
