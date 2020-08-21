package pl.pg.tmanager.role;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.user.User;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

   @ManyToMany
   private List<User> users;

   public Role() {
      //JPA Only
   }
}
