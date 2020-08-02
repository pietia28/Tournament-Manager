package pl.pg.tmanager.match;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.refeere.Refeere;
import pl.pg.tmanager.stadium.Stadium;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Component
public class MatchDto {
    Long id;
    private Integer matchDay;
    private LocalDateTime matchDate;
    private LocalTime start;
    private LocalTime end;
    private Stadium stadium;
    private Refeere refeere;
}
