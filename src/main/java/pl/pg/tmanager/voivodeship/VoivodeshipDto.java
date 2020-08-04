package pl.pg.tmanager.voivodeship;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
@Component
public class VoivodeshipDto {
    private Long id;
    private String name;
}
