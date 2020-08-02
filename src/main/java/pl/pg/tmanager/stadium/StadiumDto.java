package pl.pg.tmanager.stadium;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.voivodeship.Voivodeship;

@Data
@Component
public class StadiumDto {
    private Long id;
    private  String address;
    private String city;
    private String contactPerson;
    private String desciption;
    private String email;
    private String mobile;
    private String name;
    private String web;
    private Voivodeship voivodeship;
}
