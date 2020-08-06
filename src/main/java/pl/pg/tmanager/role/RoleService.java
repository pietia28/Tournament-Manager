package pl.pg.tmanager.role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.exception.ObjectNotFoundException;
import pl.pg.tmanager.message.Message;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream()
                .map(RoleDtoMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public RoleDto findById(Long id) {
        return RoleDtoMapper.EntityToDto(
                roleRepository.findById(id)
                        .orElseThrow((() -> new ObjectNotFoundException(Message.ROLE_NOT_FOUND + id)))
        );
    }

    public Role save(RoleDto roleDto) {
        return roleRepository.save(RoleDtoMapper.DtoToEntity(roleDto));
    }

    public void delete(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow((() -> new ObjectNotFoundException(Message.ROLE_NOT_FOUND + id)));
        roleRepository.deleteById(role.getId());
    }

    public Long count() {
        return roleRepository.count();
    }
}
