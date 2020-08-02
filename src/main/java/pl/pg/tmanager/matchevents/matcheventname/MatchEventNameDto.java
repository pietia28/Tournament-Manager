package pl.pg.tmanager.matchevents.matcheventname;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MatchEventNameDto {
    private Long id;
    private String name;
}
