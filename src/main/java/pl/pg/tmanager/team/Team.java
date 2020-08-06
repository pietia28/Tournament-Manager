package pl.pg.tmanager.team;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.manager.Manager;
import pl.pg.tmanager.player.Player;
import javax.persistence.*;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
