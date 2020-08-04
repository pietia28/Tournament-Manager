package pl.pg.tmanager.team;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pl.pg.tmanager.manager.Manager;
import pl.pg.tmanager.player.Player;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Size(max = 30)
    @Column(length = 30)
    private String name;

    @ManyToMany
    private List<Manager> managers;

    @ManyToMany
    private List<Player> players;

    public Team() {
        //JPA Only
    }
}
