package pl.pg.tmanager.stadium;

import pl.pg.tmanager.voivodeship.VoivodeshipDtoMapper;

public class StadiumDtoMapper {
    private StadiumDtoMapper() {
    }

    public static Stadium DtoToEntity(StadiumDto stadiumDto) {
        return new Stadium().setId(stadiumDto.getId())
                .setAddress(stadiumDto.getAddress())
                .setCity(stadiumDto.getCity())
                .setContactPerson(stadiumDto.getContactPerson())
                .setDescription(stadiumDto.getDescription())
                .setEmail(stadiumDto.getEmail())
                .setMobile(stadiumDto.getMobile())
                .setName(stadiumDto.getName())
                .setVoivodeship(VoivodeshipDtoMapper.DtoToEntity(stadiumDto.getVoivodeship()))
                .setWeb(stadiumDto.getWeb())
                .setZip(stadiumDto.getZip());
    }
    public static StadiumDto EntityToDto(Stadium stadium) {
        return new StadiumDto().setId(stadium.getId())
                .setAddress(stadium.getAddress())
                .setCity(stadium.getCity())
                .setContactPerson(stadium.getContactPerson())
                .setDescription(stadium.getDescription())
                .setEmail(stadium.getEmail())
                .setMobile(stadium.getMobile())
                .setName(stadium.getName())
                .setVoivodeship(VoivodeshipDtoMapper.EntityToDto(stadium.getVoivodeship()))
                .setWeb(stadium.getWeb())
                .setZip(stadium.getZip());
    }

    public static Stadium DtoToEntityVoivodeshipOnlyId(StadiumDtoVoivodeshipOnlyId stadiumDtoVoivodeshipOnlyId) {
        return new Stadium().setId(stadiumDtoVoivodeshipOnlyId.getId())
                .setAddress(stadiumDtoVoivodeshipOnlyId.getAddress())
                .setCity(stadiumDtoVoivodeshipOnlyId.getCity())
                .setContactPerson(stadiumDtoVoivodeshipOnlyId.getContactPerson())
                .setDescription(stadiumDtoVoivodeshipOnlyId.getDescription())
                .setEmail(stadiumDtoVoivodeshipOnlyId.getEmail())
                .setMobile(stadiumDtoVoivodeshipOnlyId.getMobile())
                .setName(stadiumDtoVoivodeshipOnlyId.getName())
                .setVoivodeship(VoivodeshipDtoMapper.DtoToEntityOnlyId(stadiumDtoVoivodeshipOnlyId.getVoivodeship()))
                .setWeb(stadiumDtoVoivodeshipOnlyId.getWeb())
                .setZip(stadiumDtoVoivodeshipOnlyId.getZip());
    }
}
