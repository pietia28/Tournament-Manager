package pl.pg.tmanager.referee;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.user.UserDto;

@Data
@Accessors(chain = true)
public class RefereeDto {
    private Long id;
    private UserDto user;
}
