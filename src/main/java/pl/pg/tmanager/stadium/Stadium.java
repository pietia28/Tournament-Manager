package pl.pg.tmanager.stadium;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pg.tmanager.voivodeship.Voivodeship;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100, unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 6)
    @Column(length = 6)
    private String zip;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "contact_person", length = 50)
    private String contactPerson;

    @Size(max = 50)
    @Column(length = 50)
    private String web;

    @Size(max = 60)
    @Column(length = 60, unique = true)
    private String email;

    @Size(max = 15)
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
