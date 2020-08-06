package pl.pg.tmanager.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public List<ManagerDto> findAll() {
        return managerRepository.findAll().stream()
                .map(ManagerDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public ManagerDto findById(Long id) {
        return ManagerDtoMapper.EntityToDto(
                managerRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.MANAGER_NOT_FOUND + id)))
        );
    }

    public Manager save(ManagerDto managerDto) {
        return managerRepository.save(ManagerDtoMapper.DtoToEntity(managerDto));
    }

    public void delete(Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.MANAGER_NOT_FOUND + id)));
        managerRepository.deleteById(manager.getId());
    }

    public Long count() {
        return managerRepository.count();
    }
}
