package pl.pg.tmanager.user;

import lombok.Data;
import pl.pg.tmanager.dtoMapping.annotation.Dto;
import pl.pg.tmanager.dtoMapping.annotation.HasForeignEntity;
import pl.pg.tmanager.role.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@HasForeignEntity(entityName = {"role"})
@Table(name = "users")
public class User {

    @Dto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(name = "first_name", length = 30)
    private String firstName;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(name = "last_name", length = 30)
    private String lastName;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(length = 30, unique = true)
    private String nick;

    @NotNull
    @NotBlank
    @Size(max = 255)
    @Column(length = 255)
    private String password;

    @Dto
    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(length = 60, unique = true)
    private String email;

    @Dto
    @Size(max = 15)
    @Column(length = 15, unique = true)
    private String mobile;

    private LocalDateTime created;

    private LocalDateTime updated;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Size(max = 15)
    @Column(name = "last_login_ip", length = 15)
    private String lastLoginIp;

    @Dto
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
