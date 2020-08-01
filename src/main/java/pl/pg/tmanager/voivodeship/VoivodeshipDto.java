package pl.pg.tmanager.voivodeship;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class VoivodeshipDto {
    private Long id;
    private String name;
}
