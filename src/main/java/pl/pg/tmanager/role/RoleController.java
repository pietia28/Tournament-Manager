package pl.pg.tmanager.role;

import org.springframework.web.bind.annotation.*;
import pl.pg.tmanager.exception.ExceptionJSONInfo;
import pl.pg.tmanager.message.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/role")
public class RoleController {


    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("")
    public Map<String, Object> save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @GetMapping("")
    public List<Map<String, Object>> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        return roleService.delete(id);
    }

    @GetMapping("/count")
    public Long count() {
        return roleService.count();
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseBody
    private ExceptionJSONInfo handleRoleNotFoundException(HttpServletRequest request, Exception ex){

        ExceptionJSONInfo exceptionJSONInfo = new ExceptionJSONInfo();
        exceptionJSONInfo.setUrl(request.getRequestURL().toString());
        exceptionJSONInfo.setMessage(ex.getMessage());
        exceptionJSONInfo.setStatus(Message.ERROR);

        return exceptionJSONInfo;
    }

}
//TODO sprawdzić modyfikatory dostępu