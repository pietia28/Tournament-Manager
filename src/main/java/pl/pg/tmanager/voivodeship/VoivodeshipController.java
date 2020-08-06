package pl.pg.tmanager.voivodeship;

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
@RequestMapping("/voivodeship")
public class VoivodeshipController {
    private final VoivodeshipService voivodeshipService;

    @GetMapping()
    ResponseEntity<List<VoivodeshipDto>> findAll() {
        return ResponseEntity.ok()
                .body(voivodeshipService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<VoivodeshipDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(voivodeshipService.findById(id));
    }

    @PutMapping()
    ResponseEntity<VoivodeshipDto> update(@Valid @RequestBody VoivodeshipDto voivodeshipDto) {
        Voivodeship nVoivodeship = voivodeshipService.save(voivodeshipDto);
        return ResponseEntity.ok().body(VoivodeshipDtoMapper.EntityToDto(nVoivodeship));
    }

    @PostMapping()
    ResponseEntity<URI> save(@Valid @RequestBody VoivodeshipDto voivodeshipDto) {
        Voivodeship voivodeship = voivodeshipService.save(voivodeshipDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(voivodeship.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        voivodeshipService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.VOIVODESHIP_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/count")
    Long count() {
        return voivodeshipService.count();
    }
}
