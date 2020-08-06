package pl.pg.tmanager.stadium;

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
@RequestMapping("/stadiums")
public class StadiumController {
    private final StadiumService stadiumService;

    @GetMapping()
    ResponseEntity<List<StadiumDto>> findAll() {
        return ResponseEntity.ok()
                .body(stadiumService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<StadiumDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(stadiumService.findById(id));
    }

    @PutMapping()
    ResponseEntity<StadiumDto> update(@Valid @RequestBody StadiumDto stadiumDto) {
        Stadium nStadium = stadiumService.save(stadiumDto);
        return ResponseEntity.ok().body(StadiumDtoMapper.EntityToDto(nStadium));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody StadiumDto stadiumDto) {
        Stadium stadium = stadiumService.save(stadiumDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(stadium.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        stadiumService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.STADIUM_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return stadiumService.count();
    }
}
