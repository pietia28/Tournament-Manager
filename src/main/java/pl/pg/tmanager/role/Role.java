package pl.pg.tmanager.role;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "roles")
 public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @NotNull
   @NotBlank
   @Size(max = 40)
   @Column(length = 40, unique = true)
   private String name;

   public Role() {
      //JPA Only
   }
}
