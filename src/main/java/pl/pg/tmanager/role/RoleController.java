package pl.pg.tmanager.role;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pg.tmanager.message.Message;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping()
    ResponseEntity<List<RoleDto>> findAll() {
        return ResponseEntity.ok()
                .body(roleService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<RoleDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(roleService.findById(id));
    }

    @PutMapping()
    ResponseEntity<RoleDto> update(@Valid @RequestBody RoleDto roleDto) {
        Role nRole = roleService.save(roleDto);
        return ResponseEntity.ok().body(RoleDtoMapper.EntityToDto(nRole));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody RoleDto roleDto) {
        Role role = roleService.save(roleDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(role.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        roleService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.ROLE_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return roleService.count();
    }
}
//TODO sprawdzić modyfikatory dostępu