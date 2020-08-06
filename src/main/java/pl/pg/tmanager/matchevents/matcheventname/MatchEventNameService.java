package pl.pg.tmanager.matchevents.matcheventname;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchEventNameService {
    private final MatchEventNameRepository matchEventNameRepository;

    public List<MatchEventNameDto> findAll() {
        return matchEventNameRepository.findAll().stream()
                .map(MatchEventNameDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public MatchEventNameDto findById(Long id) {
        return MatchEventNameDtoMapper.EntityToDto(
                matchEventNameRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.MATCH_EVENT_NAME_NOT_FOUND + id)))
        );
    }

    public MatchEventName save(MatchEventNameDto matchEventNameDto) {
        return matchEventNameRepository.save(MatchEventNameDtoMapper.DtoToEntity(matchEventNameDto));
    }

    public void delete(Long id) {
        MatchEventName matchEventName = matchEventNameRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.MATCH_EVENT_NAME_NOT_FOUND + id)));
        matchEventNameRepository.deleteById(matchEventName.getId());
    }

    public Long count() {
        return matchEventNameRepository.count();
    }
}
