package pl.pg.tmanager.player;

import lombok.Data;
import pl.pg.tmanager.user.User;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Player() {
        //JPA Only
    }
}
