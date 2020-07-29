package pl.pg.tmanager.voivodeship;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.pg.tmanager.exception.ExceptionJSONInfo;
import pl.pg.tmanager.message.Message;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/voivodeship")
public class VoivodeshipController {
    private final VoivodeshipService voivodeshipService;

    public VoivodeshipController(VoivodeshipService voivodeshipService) {
        this.voivodeshipService = voivodeshipService;
    }

    @PostMapping("")
    public Map<String, Object> save(@RequestBody Voivodeship voivodeship) {
        return voivodeshipService.save(voivodeship);
    }

    @GetMapping("")
    public List<Map<String, Object>> findAll() {
        return voivodeshipService.findAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        return voivodeshipService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        return voivodeshipService.delete(id);
    }

    @GetMapping("/count")
    public Long count() {
        return voivodeshipService.count();
    }

    @ExceptionHandler(VoivodeshipNotFoundException.class)
    @ResponseBody
    private ExceptionJSONInfo handleVoivodeshipNotFoundException(HttpServletRequest request, Exception ex){

        ExceptionJSONInfo exceptionJSONInfo = new ExceptionJSONInfo();
        exceptionJSONInfo.setUrl(request.getRequestURL().toString());
        exceptionJSONInfo.setMessage(ex.getMessage());
        exceptionJSONInfo.setStatus(Message.ERROR);

        return exceptionJSONInfo;
    }
}
