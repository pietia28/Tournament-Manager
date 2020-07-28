package pl.pg.tmanager.role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pg.tmanager.dtoMapping.annotation.Dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@Table(name = "roles")
 public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 40)
    @Column(length = 40, unique = true)
    private String name;

    public Role() {
        //JPA Only
    }
}
