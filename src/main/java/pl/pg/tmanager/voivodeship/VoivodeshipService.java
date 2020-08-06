package pl.pg.tmanager.voivodeship;

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
public class VoivodeshipService {
    private final VoivodeshipRepository voivodeshipRepository;

    public List<VoivodeshipDto> findAll() {
        return voivodeshipRepository.findAll().stream()
                .map(VoivodeshipDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public VoivodeshipDto findById(Long id) {
        return VoivodeshipDtoMapper.EntityToDto(
                voivodeshipRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.USER_NOT_FOUND + id)))
        );
    }

    public Voivodeship save(VoivodeshipDto voivodeshipDto) {
        return voivodeshipRepository.save(VoivodeshipDtoMapper.DtoToEntity(voivodeshipDto));
    }

    public void delete(Long id) {
        Voivodeship voivodeship = voivodeshipRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.VOIVODESHIP_NOT_FOUND + id)));
        voivodeshipRepository.deleteById(voivodeship.getId());
    }

    public Long count() {
        return voivodeshipRepository.count();
    }
}
