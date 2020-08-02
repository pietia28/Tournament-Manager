package pl.pg.tmanager.manager;

import lombok.Data;
import pl.pg.tmanager.user.User;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Manager() {
        //JPA Only
    }
}
