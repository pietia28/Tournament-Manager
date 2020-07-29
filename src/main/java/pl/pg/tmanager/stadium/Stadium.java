package pl.pg.tmanager.stadium;

import lombok.Data;
import pl.pg.tmanager.dtoMapping.annotation.Dto;
import pl.pg.tmanager.dtoMapping.annotation.HasForeignEntity;
import pl.pg.tmanager.voivodeship.Voivodeship;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "stadiums")
@HasForeignEntity(entityName = {"voivodeship"})
public class Stadium {
    @Dto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100, unique = true)
    private String name;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String address;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 6)
    @Column(length = 6)
    private String zip;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(length = 50)
    private String city;

    @Dto
    @Size(max = 50)
    @Column(name = "contact_person", length = 50)
    private String contactPerson;

    @Dto
    @Size(max = 50)
    @Column(length = 50)
    private String web;

    @Dto
    @Size(max = 60)
    @Column(length = 60, unique = true)
    private String email;

    @Dto
    @Size(max = 15)
    @Column(length = 15, unique = true)
    private String mobile;

    @Dto
    private String description;

    @Dto
    @ManyToOne
    @JoinColumn(name = "voivodeship_id")
    private Voivodeship voivodeship;

    public Stadium() {
        //JPA Only
    }
}
