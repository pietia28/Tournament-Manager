package pl.pg.tmanager.stadium;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.voivodeship.Voivodeship;
import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 6)
    private String zip;

    @Column(length = 50)
    private String city;

    @Column(name = "contact_person", length = 50)
    private String contactPerson;

    @Column(length = 50)
    private String web;

    @Column(length = 60, unique = true)
    private String email;

    @Column(length = 15, unique = true)
    private String mobile;

    private String description;

    @ManyToOne
    @JoinColumn(name = "voivodeship_id")
    private Voivodeship voivodeship;

    public Stadium() {
        //JPA Only
    }
}
