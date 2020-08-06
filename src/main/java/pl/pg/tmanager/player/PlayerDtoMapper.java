package pl.pg.tmanager.player;

import pl.pg.tmanager.user.UserDtoMapper;

public class PlayerDtoMapper {
    private PlayerDtoMapper() {
    }

    public static Player DtoToEntity(PlayerDto playerDto) {
        return new Player().setId(playerDto.getId())
                .setUser(UserDtoMapper.DtoToEntity(playerDto.getUser()));
    }

    public static PlayerDto EntityToDto(Player player) {
        return new PlayerDto().setId(player.getId())
                .setUser(UserDtoMapper.EntityToDto(player.getUser()));
    }
}
