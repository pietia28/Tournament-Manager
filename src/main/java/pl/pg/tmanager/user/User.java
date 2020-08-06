package pl.pg.tmanager.user;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.role.Role;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(length = 30, unique = true)
    private String nick;

    @Column(length = 255)
    private String password;

    @Column(length = 60, unique = true)
    private String email;

    @Column(length = 15, unique = true)
    private String mobile;

    private LocalDateTime created;

    private LocalDateTime updated;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "last_login_ip", length = 15)
    private String lastLoginIp;

    @ManyToMany
    private List<Role> role;

    public User() {
        //JPA Only
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
