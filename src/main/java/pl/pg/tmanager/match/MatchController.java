package pl.pg.tmanager.match;

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
@RequestMapping("/matches")
class MatchController {
    private final MatchService matchService;

    @GetMapping()
    ResponseEntity<List<MatchDto>> findAll() {
        return ResponseEntity.ok()
                .body(matchService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<MatchDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(matchService.findById(id));
    }

    @PutMapping()
    ResponseEntity<MatchDto> update(@Valid @RequestBody MatchDto matchDto) {
        Match nMatch = matchService.save(matchDto);
        return ResponseEntity.ok().body(MatchDtoMapper.EntityToDto(nMatch));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody MatchDto matchDto) {
        Match nMatch = matchService.save(matchDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nMatch.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        matchService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.MATCH_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return matchService.count();
    }
}
