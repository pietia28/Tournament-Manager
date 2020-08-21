package pl.pg.tmanager.tournament;

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
@RequestMapping("/tournaments")
class TournamentController {
    private final TournamentService tournamentService;

    @GetMapping()
    ResponseEntity<List<TournamentDto>> findAll() {
        return ResponseEntity.ok()
                .body(tournamentService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<TournamentDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(tournamentService.findById(id));
    }

    @PutMapping()
    ResponseEntity<TournamentDto> update(@Valid @RequestBody TournamentDto tournamentDto) {
        Tournament nTournament = tournamentService.save(tournamentDto);
        return ResponseEntity.ok().body(TournamentDtoMapper.EntityToDto(nTournament));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody TournamentDto tournamentDto) {
        System.out.println("TEST");
        Tournament tournament = tournamentService.save(tournamentDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tournament.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        tournamentService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.TOURNAMENT_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return tournamentService.count();
    }
}
