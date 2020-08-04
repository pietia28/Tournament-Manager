package pl.pg.tmanager.user;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.role.Role;
import pl.pg.tmanager.role.RoleDto;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserDto {
    private Long id;
    private String email;
    private String firtstName;
    private String lastName;
    private String nick;
    private List<RoleDto> role;
}
