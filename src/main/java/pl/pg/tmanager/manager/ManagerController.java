package pl.pg.tmanager.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pg.tmanager.message.Message;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/managers")
class ManagerController {
    private final ManagerService managerService;

    @GetMapping()
    ResponseEntity<List<ManagerDto>> findAll() {
        return ResponseEntity.ok()
                .body(managerService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ManagerDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(managerService.findById(id));
    }

    @PutMapping()
    ResponseEntity<ManagerDto> update(@Valid @RequestBody ManagerDto managerDto) {
        Manager nManager = managerService.save(managerDto);
        return ResponseEntity.ok().body(ManagerDtoMapper.EntityToDto(nManager));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody ManagerDto managerDto) {
        Manager nManager = managerService.save(managerDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nManager.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        managerService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.MANAGER_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return managerService.count();
    }
}
//TODO dodać obsługę wyjątku java.sql.SQLIntegrityConstraintViolationException podczas tworzenia nowego rekordu
//TODO w przypadku jezeli manager zawiera usera o nieistniejącym ID
//TODO dodać NOTUNIQUE - nie pozwolić na zapis jeśli rekord istnieje
//TODO Zastanowić się nad sensem metod save i update - manger bedzie dodawany do listy ról przy edycji usera