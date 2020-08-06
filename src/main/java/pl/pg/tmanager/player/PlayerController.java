package pl.pg.tmanager.player;

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
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping()
    ResponseEntity<List<PlayerDto>> findAll() {
        return ResponseEntity.ok()
                .body(playerService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<PlayerDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(playerService.findById(id));
    }

    @PutMapping()
    ResponseEntity<PlayerDto> update(@Valid @RequestBody PlayerDto playerDto) {
        Player nPlayer = playerService.save(playerDto);
        return ResponseEntity.ok().body(PlayerDtoMapper.EntityToDto(nPlayer));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody PlayerDto playerDto) {
        Player player = playerService.save(playerDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(player.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        playerService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.PLAYER_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return playerService.count();
    }
}
//TODO dodać obsługę wyjątku java.sql.SQLIntegrityConstraintViolationException podczas tworzenia nowego rekordu
//TODO w przypadku jezeli player zawiera usera o nieistniejącym ID

