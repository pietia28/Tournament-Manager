package pl.pg.tmanager.referee;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.user.User;
import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "referees")
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Referee() {
        //JPA Only
    }
}
