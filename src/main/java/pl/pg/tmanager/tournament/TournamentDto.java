package pl.pg.tmanager.tournament;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.match.MatchDto;
import pl.pg.tmanager.message.Message;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class TournamentDto {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 60, message = Message.VALID_MAX_SIZE + 60)
    private String name;

    @NotNull(message = Message.VALID_NOT_NULL)
    private LocalDateTime start;

    @NotNull(message = Message.VALID_NOT_NULL)
    private LocalDateTime end;

    private String description;

    private List<MatchDto> matches;
}
