package pl.pg.tmanager.voivodeship;

import lombok.Data;
import pl.pg.tmanager.dtoMapping.annotation.Dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "voivodeships")
public class Voivodeship {
    @Dto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 25)
    @Column(length = 25, unique = true)
    private String name;

    public Voivodeship() {
        //JPA Only
    }
}
