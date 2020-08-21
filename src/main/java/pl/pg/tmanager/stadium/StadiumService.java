package pl.pg.tmanager.stadium;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class StadiumService {
    private final StadiumRepository stadiumRepository;

    public List<StadiumDto> findAll() {
        return stadiumRepository.findAll().stream()
                .map(StadiumDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public StadiumDto findById(Long id) {
        return StadiumDtoMapper.EntityToDto(
                stadiumRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.STADIUM_NOT_FOUND + id)))
        );
    }

    public Stadium save(StadiumDtoVoivodeshipOnlyId stadiumDtoVoivodeshipOnlyId) {
        return stadiumRepository.save(StadiumDtoMapper.DtoToEntityVoivodeshipOnlyId(stadiumDtoVoivodeshipOnlyId));
    }

    public void delete(Long id) {
        Stadium stadium = stadiumRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.STADIUM_NOT_FOUND + id)));
        stadiumRepository.deleteById(stadium.getId());
    }

    public Long count() {
        return stadiumRepository.count();
    }
}
//TODO dodać logi
