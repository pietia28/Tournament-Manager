package pl.pg.tmanager.player;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.user.User;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_number")
    private Short playerNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public Player() {
        //JPA Only
    }
}
//TODO dodać numer na koszulce
//TODO pomyśleć nad punktami umięjętności jak w FIFA
