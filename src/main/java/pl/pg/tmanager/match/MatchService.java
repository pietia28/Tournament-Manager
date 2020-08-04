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
        List<Match> matchList = matchRepository.findAll();
        return matchList.stream()
                .map(MatchMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public MatchDto findById(Long id) {
        return MatchMapper.EntityToDto(
                matchRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.MATCH_NOT_FOUND + id)))
        );
    }

    public Match save(MatchDto matchDto) {
        return matchRepository.save(MatchMapper.DtoToEntity(matchDto));
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
