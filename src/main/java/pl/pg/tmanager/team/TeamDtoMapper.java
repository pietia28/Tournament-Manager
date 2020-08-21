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
                .setDescription(teamDto.getDescription());
                /*.setManagers(teamDto.getManagers().stream()
                        .map(ManagerDtoMapper::DtoToEntity)
                        .collect(Collectors.toList())
                )
                .setPlayers(teamDto.getPlayers().stream()
                        .map(PlayerDtoMapper::DtoToEntity)
                        .collect(Collectors.toList()));*/
    }

    public static TeamDto EntityToDto(Team team) {
        return new TeamDto().setId(team.getId())
                .setName(team.getName())
                .setDescription(team.getDescription());
                /*.setManagers(team.getManagers().stream()
                        .map(ManagerDtoMapper::EntityToDto)
                        .collect(Collectors.toList())
                )
                .setPlayers(team.getPlayers().stream()
                        .map(PlayerDtoMapper::EntityToDto)
                        .collect(Collectors.toList()));*/
    }

    public static TeamDtoExtended EntityToDtoExtended(Team team) {
        return new TeamDtoExtended().setId(team.getId())
                .setName(team.getName())
                .setDescription(team.getDescription())
                .setManagers(team.getManagers().stream()
                        .map(ManagerDtoMapper::EntityToDto)
                        .collect(Collectors.toList())
                )
                .setPlayers(team.getPlayers().stream()
                        .map(PlayerDtoMapper::EntityToDto)
                        .collect(Collectors.toList()));
    }

    public static Team DtoToEntityExtended(TeamDtoExtended teamDtoExtended) {
        return new Team().setId(teamDtoExtended.getId())
                .setName(teamDtoExtended.getName())
                .setDescription(teamDtoExtended.getDescription())
                .setManagers(teamDtoExtended.getManagers().stream()
                        .map(ManagerDtoMapper::DtoToEntity)
                        .collect(Collectors.toList())
                )
                .setPlayers(teamDtoExtended.getPlayers().stream()
                        .map(PlayerDtoMapper::DtoToEntity)
                        .collect(Collectors.toList()));
    }
}
