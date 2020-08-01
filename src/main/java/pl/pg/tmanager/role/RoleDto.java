package pl.pg.tmanager.role;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RoleDto {
    private Long id;
    private String name;

}
