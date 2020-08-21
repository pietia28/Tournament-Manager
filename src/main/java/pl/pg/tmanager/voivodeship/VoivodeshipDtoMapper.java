package pl.pg.tmanager.voivodeship;
public class VoivodeshipDtoMapper {

    public static Voivodeship DtoToEntity(VoivodeshipDto voivodeshipDto) {
        return new Voivodeship().setId(voivodeshipDto.getId())
                .setName(voivodeshipDto.getName());
    }

    public static VoivodeshipDto EntityToDto(Voivodeship voivodeship) {
        return new VoivodeshipDto().setId(voivodeship.getId())
                .setName(voivodeship.getName());
    }

    public static Voivodeship DtoToEntityOnlyId(VoivodeshipOnlyIdDto voivodeshipOnlyIdDto) {
        return new Voivodeship().setId(voivodeshipOnlyIdDto.getId());
    }
}
