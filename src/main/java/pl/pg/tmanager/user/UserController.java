package pl.pg.tmanager.user;

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
@RequestMapping("/users")
class UserController {
    private final UserService userService;

    @GetMapping()
    ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok()
                .body(userService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(userService.findById(id));
    }

    @PutMapping()
    ResponseEntity<UserDto> update(@Valid @RequestBody UserDtoUpdate userDtoUpdate) {
        User nUser = userService.update(userDtoUpdate);
        return ResponseEntity.ok().body(UserDtoMapper.EntityToDto(nUser));
    }

    @PostMapping()
    ResponseEntity<?> save(@Valid @RequestBody UserDtoCreate userDtoCreate) {
        User user = userService.save(userDtoCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map> delete(@PathVariable Long id) {
        userService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put(Message.STATUS, Message.OK);
        response.put(Message.MESSAGE, Message.USER_DELETED + id);
        return ResponseEntity.ok().body(response);
    }

    /*@PostMapping{"/password/update"}
    ResponseEntity<?> passwordUpdate(@PathVariable UserDtoPassword userDtoPassword) {

    }*/

    @GetMapping("/count")
    Long count() {
        return userService.count();
    }
}
//TODO dopisać zmianę hasła