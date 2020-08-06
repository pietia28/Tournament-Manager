package pl.pg.tmanager.team;

import pl.pg.tmanager.manager.ManagerDtoMapper;
import pl.pg.tmanager.player.PlayerDtoMapper;
import java.util.stream.Collectors;

public class TeamDtoMapper {
    private TeamDtoMapper() {
    }

    public static Team DtoToEntity(TeamDto teamDto) {
        return new Team().setId(teamDto.getId())
                .setName(teamDto.getName())
                .setManagers(teamDto.getManagers().stream()
                        .map(ManagerDtoMapper::DtoToEntity)
                        .collect(Collectors.toList())
                )
                .setPlayers(teamDto.getPlayers().stream()
                        .map(PlayerDtoMapper::DtoToEntity)
                        .collect(Collectors.toList()));
    }

    public static TeamDto EntityToDto(Team team) {
        return new TeamDto().setId(team.getId())
                .setName(team.getName())
                .setManagers(team.getManagers().stream()
                        .map(ManagerDtoMapper::EntityToDto)
                        .collect(Collectors.toList())
                )
                .setPlayers(team.getPlayers().stream()
                        .map(PlayerDtoMapper::EntityToDto)
                        .collect(Collectors.toList()));
    }
}
