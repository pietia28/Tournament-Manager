package pl.pg.tmanager.matchevents.matcheventname;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.message.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class MatchEventNameDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 30, message = Message.VALID_MAX_SIZE + 30)
    private String name;
}
