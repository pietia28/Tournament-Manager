package pl.pg.tmanager.tournament;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.match.Match;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Component
public class TournamentDto {
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<Match> matches;
}
