package pl.pg.tmanager.match;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public List<MatchDto> findAll() {
        return matchRepository.findAll().stream()
                .map(MatchDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public MatchDto findById(Long id) {
        return MatchDtoMapper.EntityToDto(
                matchRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.MATCH_NOT_FOUND + id)))
        );
    }

    public Match save(MatchDto matchDto) {
        return matchRepository.save(MatchDtoMapper.DtoToEntity(matchDto));
    }

    public void delete(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.MATCH_NOT_FOUND + id)));
        matchRepository.deleteById(match.getId());
    }

    public Long count() {
        return matchRepository.count();
    }
}
