package pl.pg.tmanager.matchevents.matchevent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchEventService {
    private final MatchEventRepository matchEventRepository;

    public List<MatchEventDto> findAll() {
        return matchEventRepository.findAll().stream()
                .map(MatchEventDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public MatchEventDto findById(Long id) {
        return MatchEventDtoMapper.EntityToDto(
                matchEventRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.MATCH_EVENT_NOT_FOUND + id)))
        );
    }

    public MatchEvent save(MatchEventDto matchEventDto) {
        return matchEventRepository.save(MatchEventDtoMapper.DtoToEntity(matchEventDto));
    }

    public void delete(Long id) {
        MatchEvent matchEvent = matchEventRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.MATCH_EVENT_NOT_FOUND + id)));
        matchEventRepository.deleteById(matchEvent.getId());
    }

    public Long count() {
        return matchEventRepository.count();
    }
}
