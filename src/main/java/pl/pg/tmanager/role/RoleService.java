package pl.pg.tmanager.role;

import org.springframework.stereotype.Service;
import pl.pg.tmanager.interfaces.CrudOperations;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements CrudOperations<Role> {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole;
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Long count() {
        return roleRepository.count();
    }

}
