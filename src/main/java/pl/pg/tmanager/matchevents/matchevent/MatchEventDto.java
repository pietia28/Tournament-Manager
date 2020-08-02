package pl.pg.tmanager.matchevents.matchevent;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.matchevents.matcheventname.MatchEventName;
import java.time.LocalTime;

@Data
@Component
public class MatchEventDto {
    Long id;
    private LocalTime time;
    private MatchEventName matchEventName;
}
