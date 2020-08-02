package pl.pg.tmanager.manager;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.user.User;

@Data
@Component
public class ManagerDto {
    private  Long id;
    private User user;
}
