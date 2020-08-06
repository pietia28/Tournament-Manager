package pl.pg.tmanager.user;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.role.RoleDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Accessors(chain = true)
public class UserDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 30, message = Message.VALID_MAX_SIZE + 30)
    private String firtstName;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 30, message = Message.VALID_MAX_SIZE)
    private String lastName;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 60, message = Message.VALID_MAX_SIZE + 60)
    private String email;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 30, message = Message.VALID_MAX_SIZE + 30)
    private String nick;

    private List<RoleDto> role;
}
