package pl.pg.tmanager.integration.weather.accuweather;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "weathers")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private Double temperature;

    public Weather() {
        //JPA Only
    }
}
