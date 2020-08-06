package pl.pg.tmanager.role;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "roles")
 public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(length = 40, unique = true)
   private String name;

   public Role() {
      //JPA Only
   }
}
