package pl.pg.tmanager.role;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
public class RoleDto {
    private Long id;
    private String name;
}
