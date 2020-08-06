package pl.pg.tmanager.tournament;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public List<TournamentDto> findAll() {
        return tournamentRepository.findAll().stream()
                .map(TournamentDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public TournamentDto findById(Long id) {
        return TournamentDtoMapper.EntityToDto(
                tournamentRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.TOURNAMENT_NOT_FOUND + id)))
        );
    }

    public Tournament save(TournamentDto tournamentDto) {
        return tournamentRepository.save(TournamentDtoMapper.DtoToEntity(tournamentDto));
    }

    public void delete(Long id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.TOURNAMENT_NOT_FOUND + id)));
        tournamentRepository.deleteById(tournament.getId());
    }

    public Long count() {
        return tournamentRepository.count();
    }
}
