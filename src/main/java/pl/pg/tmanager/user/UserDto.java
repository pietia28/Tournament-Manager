package pl.pg.tmanager.user;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.role.Role;

import java.util.List;

@Data
@Component
public class UserDto {
    private Long id;
    private String email;
    private String firtstName;
    private String lastName;
    private String nick;
    private List<Role> role;
}
