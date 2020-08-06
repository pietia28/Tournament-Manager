package pl.pg.tmanager.role;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.message.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class RoleDto {
    private Long id;

    @Size(max = 40, message = Message.VALID_MAX_SIZE + 40)
    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    private String name;
}
