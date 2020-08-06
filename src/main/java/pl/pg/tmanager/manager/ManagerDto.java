package pl.pg.tmanager.manager;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.message.Message;;
import pl.pg.tmanager.user.UserDto;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@Component
public class ManagerDto {
    private  Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    private UserDto user;
}
