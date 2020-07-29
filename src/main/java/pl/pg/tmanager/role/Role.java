package pl.pg.tmanager.role;

import lombok.Data;
import pl.pg.tmanager.dtoMapping.annotation.Dto;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "roles")
 public class Role {

   @Dto
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
