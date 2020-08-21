package pl.pg.tmanager.stadium;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pg.tmanager.message.Message;
import pl.pg.tmanager.voivodeship.VoivodeshipDto;
import pl.pg.tmanager.voivodeship.VoivodeshipOnlyIdDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class StadiumDtoVoivodeshipOnlyId {
    private Long id;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 100, message = Message.VALID_MAX_SIZE + 100)
    private String name;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 100, message = Message.VALID_MAX_SIZE + 100)
    private  String address;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 6, message = Message.VALID_MAX_SIZE + 6)
    private String zip;

    @NotNull(message = Message.VALID_NOT_NULL)
    @NotBlank(message = Message.VALID_NOT_BALNK)
    @Size(max = 50, message = Message.VALID_MAX_SIZE + 50)
    private String city;

    @Size(max = 50, message = Message.VALID_MAX_SIZE + 50)
    private String contactPerson;

    @Size(max = 50, message = Message.VALID_MAX_SIZE + 50)
    private String web;

    @Email(message = Message.VALID_EMAIL)
    @Size(max = 60, message = Message.VALID_MAX_SIZE + 60)
    private String email;

    @Size(max = 15, message = Message.VALID_MAX_SIZE + 15)
    private String mobile;

    private String description;

    private VoivodeshipOnlyIdDto voivodeship;
}
