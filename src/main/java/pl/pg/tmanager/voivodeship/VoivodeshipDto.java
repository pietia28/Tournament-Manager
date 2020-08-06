package pl.pg.tmanager.voivodeship;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.message.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class VoivodeshipDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 25, message = Message.VALID_MAX_SIZE + 25)
    private String name;
}
