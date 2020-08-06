package pl.pg.tmanager.referee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RefereeService {
    private final RefereeRepository refereeRepository;

    public List<RefereeDto> findAll() {
        return refereeRepository.findAll().stream()
                .map(RefereeDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public RefereeDto findById(Long id) {
        return RefereeDtoMapper.EntityToDto(
                refereeRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.REFEREE_NOT_FOUND + id)))
        );
    }

    public Referee save(RefereeDto refereeDto) {
        return refereeRepository.save(RefereeDtoMapper.DtoToEntity(refereeDto));
    }

    public void delete(Long id) {
        Referee referee = refereeRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.REFEREE_NOT_FOUND + id)));
        refereeRepository.deleteById(referee.getId());
    }

    public Long count() {
        return refereeRepository.count();
    }
}
