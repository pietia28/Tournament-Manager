package pl.pg.tmanager.user;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.message.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class UserDtoPassword {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    private String password;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    private String oldPassword;
}
