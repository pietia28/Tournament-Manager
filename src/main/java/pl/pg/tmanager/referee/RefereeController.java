package pl.pg.tmanager.referee;

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
@RequestMapping("/referees")
class RefereeController {
    private final RefereeService refereeService;

    @GetMapping()
    ResponseEntity<List<RefereeDto>> findAll() {
        return ResponseEntity.ok()
                .body(refereeService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<RefereeDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(refereeService.findById(id));
    }

    @PutMapping()
    ResponseEntity<RefereeDto> update(@Valid @RequestBody RefereeDto refereeDto) {
        Referee nReferee = refereeService.save(refereeDto);
        return ResponseEntity.ok().body(RefereeDtoMapper.EntityToDto(nReferee));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody RefereeDto refereeDto) {
        Referee referee = refereeService.save(refereeDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(referee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        refereeService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.REFEREE_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return refereeService.count();
    }
}
//TODO dodać obsługę wyjątku java.sql.SQLIntegrityConstraintViolationException podczas tworzenia nowego rekordu
//TODO w przypadku jezeli referee zawiera usera o nieistniejącym ID