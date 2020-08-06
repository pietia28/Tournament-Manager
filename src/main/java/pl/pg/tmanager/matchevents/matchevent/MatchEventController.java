package pl.pg.tmanager.matchevents.matchevent;

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
@RequestMapping("/events")
public class MatchEventController {
    private final MatchEventService matchEventService;

    @GetMapping()
    ResponseEntity<List<MatchEventDto>> findAll() {
        return ResponseEntity.ok()
                .body(matchEventService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<MatchEventDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(matchEventService.findById(id));
    }

    @PutMapping()
    ResponseEntity<MatchEventDto> update(@Valid @RequestBody MatchEventDto managerDto) {
        MatchEvent nMatchEvent = matchEventService.save(managerDto);
        return ResponseEntity.ok().body(MatchEventDtoMapper.EntityToDto(nMatchEvent));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody MatchEventDto managerDto) {
        MatchEvent nMatchEvent = matchEventService.save(managerDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nMatchEvent.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        matchEventService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.MATCH_EVENT_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return matchEventService.count();
    }
}

//TODO rozważyć wiązanie dwustronne
//TODO dodać obsługę wyjątku java.sql.SQLIntegrityConstraintViolationException podczas tworzenia nowego rekordu
//TODO w przypadku jezeli match event zawiera usera o nieistniejącym ID
