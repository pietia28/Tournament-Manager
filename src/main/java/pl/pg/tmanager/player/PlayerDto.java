package pl.pg.tmanager.player;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.user.User;

@Data
@Component
public class PlayerDto {
    private Long id;
    private User user;
}
