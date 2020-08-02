package pl.pg.tmanager.refeere;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.user.User;

@Data
@Component
public class RefeereDto {
    private Long id;
    private User user;
}
