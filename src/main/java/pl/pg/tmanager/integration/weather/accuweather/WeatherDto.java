package pl.pg.tmanager.integration.weather.accuweather;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class WeatherDto {
    private Long id;
    private LocalDateTime date;
    private Double temperature;
}
