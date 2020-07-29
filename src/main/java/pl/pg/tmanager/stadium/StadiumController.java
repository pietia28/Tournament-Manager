package pl.pg.tmanager.stadium;

import org.springframework.web.bind.annotation.*;
import pl.pg.tmanager.exception.ExceptionJSONInfo;
import pl.pg.tmanager.message.Message;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stadium")
public class StadiumController {
    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @PostMapping("")
    public Map<String, Object> save(@RequestBody Stadium stadium) {
        return stadiumService.save(stadium);
    }

    @GetMapping("")
    public List<Map<String, Object>> findAll() {
        return stadiumService.findAll();
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        return stadiumService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        return stadiumService.delete(id);
    }

    @GetMapping("/count")
    public Long count() {
        return stadiumService.count();
    }

    @ExceptionHandler(StadiumNotFoundException.class)
    @ResponseBody
    private ExceptionJSONInfo handleStadiumNotFoundException(HttpServletRequest request, Exception ex){

        ExceptionJSONInfo exceptionJSONInfo = new ExceptionJSONInfo();
        exceptionJSONInfo.setUrl(request.getRequestURL().toString());
        exceptionJSONInfo.setMessage(ex.getMessage());
        exceptionJSONInfo.setStatus(Message.ERROR);

        return exceptionJSONInfo;
    }
}
