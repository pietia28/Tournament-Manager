package pl.pg.tmanager.referee;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.user.UserDto;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class RefereeDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    private UserDto user;
}
