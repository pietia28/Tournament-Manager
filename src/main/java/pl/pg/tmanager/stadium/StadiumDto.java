package pl.pg.tmanager.stadium;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.voivodeship.VoivodeshipDto;

@Data
@Accessors(chain = true)
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
    private String zip;
    private VoivodeshipDto voivodeship;
}
