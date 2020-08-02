package pl.pg.tmanager.integration.weather.accuweather;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Data
@Component
public class WeatherDto {
    Long id;
    private LocalDateTime date;
    private Double temperature;
}
