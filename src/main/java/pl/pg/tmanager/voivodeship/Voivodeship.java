package pl.pg.tmanager.voivodeship;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "voivodeships")
public class Voivodeship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25, unique = true)
    private String name;

    public Voivodeship() {
        //JPA Only
    }
}
