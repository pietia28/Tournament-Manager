package pl.pg.tmanager.tournament;

import pl.pg.tmanager.match.MatchDtoMapper;
import java.util.stream.Collectors;

public class TournamentDtoMapper {
    private TournamentDtoMapper() {
    }

    public static Tournament DtoToEntity(TournamentDto tournamentDto) {
        return new Tournament().setId(tournamentDto.getId())
                .setDescription(tournamentDto.getDescription())
                .setEnd(tournamentDto.getEnd())
                .setName(tournamentDto.getName())
                .setStart(tournamentDto.getStart())
                .setMatches(tournamentDto.getMatches().stream()
                        .map(MatchDtoMapper::DtoToEntity)
                        .collect(Collectors.toList()));
    }

    public static TournamentDto EntityToDto(Tournament tournament) {
        return new TournamentDto().setId(tournament.getId())
                .setDescription(tournament.getDescription())
                .setEnd(tournament.getEnd())
                .setName(tournament.getName())
                .setStart(tournament.getStart())
                .setMatches(tournament.getMatches().stream()
                        .map(MatchDtoMapper::EntityToDto)
                        .collect(Collectors.toList()));
    }
}
