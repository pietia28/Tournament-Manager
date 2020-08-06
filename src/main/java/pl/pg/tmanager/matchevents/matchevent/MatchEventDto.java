package pl.pg.tmanager.matchevents.matchevent;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.matchevents.matcheventname.MatchEventNameDto;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.player.PlayerDto;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@Accessors(chain = true)
public class MatchEventDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    private LocalTime time;

    private PlayerDto player;

    private MatchEventNameDto matchEventName;
}
