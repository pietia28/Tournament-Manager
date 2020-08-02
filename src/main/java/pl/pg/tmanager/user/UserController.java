package pl.pg.tmanager.user;

import org.springframework.web.bind.annotation.*;
import pl.pg.tmanager.exception.ExceptionJSONInfo;
import pl.pg.tmanager.message.Message;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public Map<String, Object> save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping()
    public List<Map<String, Object>> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/count")
    public Long count() {
        return userService.count();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    private ExceptionJSONInfo handleUserNotFoundException(HttpServletRequest request, Exception ex){

        ExceptionJSONInfo exceptionJSONInfo = new ExceptionJSONInfo();
        exceptionJSONInfo.setUrl(request.getRequestURL().toString());
        exceptionJSONInfo.setMessage(ex.getMessage());
        exceptionJSONInfo.setStatus(Message.ERROR);

        return exceptionJSONInfo;
    }
}
