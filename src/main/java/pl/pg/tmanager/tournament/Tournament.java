package pl.pg.tmanager.tournament;

import lombok.Data;
import pl.pg.tmanager.match.Match;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(length = 60, unique = true)
    private String name;

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime end;

    private String description;

    @ManyToMany
    private List<Match> matches;

    public Tournament() {
        //JPA Only
    }
}
