package pl.pg.tmanager.team;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.manager.ManagerDto;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.player.PlayerDto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Accessors(chain = true)
public class TeamDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 30, message = Message.VALID_MAX_SIZE + 30)
    private String name;

    private List<ManagerDto> managers;

    private List<PlayerDto> players;
}
