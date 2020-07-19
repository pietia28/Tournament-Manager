package pl.pg.tmanager.role;

import org.springframework.web.bind.annotation.*;
import pl.pg.tmanager.exception.ExceptionJSONInfo;
import pl.pg.tmanager.exception.RoleNotFoundException;
import pl.pg.tmanager.message.MessagesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final Validator validator;
    private final RoleService roleService;
    private final MessagesHandler<Role> messagesHandler;
    private Map<String, Object> response;

    public RoleController(
            RoleService roleService, Validator validator, MessagesHandler<Role> messagesHandler) {
        this.roleService = roleService;
        this.validator = validator;
        this.messagesHandler = messagesHandler;
    }

    @PostMapping("")
    public Map<String, Object> save(@RequestBody Role role) {
        response = new HashMap<>();
        Set<ConstraintViolation<Role>> violations = validator.validate(role);
        if (!violations.isEmpty()) {
            Map<String, List<String>> errors;
            errors = messagesHandler.getValidationMessage(validator, role);
            response.put("status", "validation error " + errors);
        } else {
            roleService.save(role);
            response.put("status", "ok");
        }
        return response;
    }

    @GetMapping("")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @PostMapping("/{id}")
    public Role findById(@PathVariable Long id) {
        Optional<Role> optionalRole = roleService.findById(id);
        return optionalRole
                .orElseThrow(() -> new RoleNotFoundException("not found"));
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        response = new HashMap<>();
        Optional<Role> optionalRole = roleService.findById(id);
        optionalRole.orElseThrow(
                () -> new RoleNotFoundException("not found")
        );
        roleService.delete(optionalRole.get());
        response.put("status", "ok");
        return response;
    }

    @GetMapping("/count")
    public Long count() {
        return roleService.count();
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseBody
    private ExceptionJSONInfo handleAuthorNotFoundException(HttpServletRequest request, Exception ex){

        ExceptionJSONInfo exceptionJSONInfo = new ExceptionJSONInfo();
        exceptionJSONInfo.setUrl(request.getRequestURL().toString());
        exceptionJSONInfo.setMessage(ex.getMessage());
        exceptionJSONInfo.setStatus("error");

        return exceptionJSONInfo;
    }

}
