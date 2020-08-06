package pl.pg.tmanager.matchevents.matcheventname;

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
@RequestMapping("/events/names")
public class MatchEventNameController {
    private final MatchEventNameService matchEventNameService;

    @GetMapping()
    ResponseEntity<List<MatchEventNameDto>> findAll() {
        return ResponseEntity.ok()
                .body(matchEventNameService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<MatchEventNameDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(matchEventNameService.findById(id));
    }

    @PutMapping()
    ResponseEntity<MatchEventNameDto> update(@Valid @RequestBody MatchEventNameDto matchEventNameDto) {
        MatchEventName nMatchEventName = matchEventNameService.save(matchEventNameDto);
        return ResponseEntity.ok().body(MatchEventNameDtoMapper.EntityToDto(nMatchEventName));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody MatchEventNameDto matchEventNameDto) {
        MatchEventName nMatchEventName = matchEventNameService.save(matchEventNameDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nMatchEventName.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        matchEventNameService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.MATCH_EVENT_NAME_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return matchEventNameService.count();
    }
}
//TODO rozwiązać sprawę UNIQUE

