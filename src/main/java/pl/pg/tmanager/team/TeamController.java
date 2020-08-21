package pl.pg.tmanager.team;

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
@RequestMapping("/teams")
class TeamController {
    private final TeamService teamService;

    @GetMapping("/extend/{id}")
    ResponseEntity<TeamDtoExtended> findAByIdExtended(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(teamService.findAllEByIdxtended(id));
    }

    @GetMapping()
    ResponseEntity<List<TeamDto>> findAll() {
        return ResponseEntity.ok()
                .body(teamService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<TeamDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(teamService.findById(id));
    }

    @PutMapping()
    ResponseEntity<TeamDto> update(@Valid @RequestBody TeamDto teamDto) {
        Team nTeam = teamService.save(teamDto);
        return ResponseEntity.ok().body(TeamDtoMapper.EntityToDto(nTeam));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody TeamDto teamDto) {
        Team team = teamService.save(teamDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(team.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        teamService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.TEAM_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return teamService.count();
    }
}
