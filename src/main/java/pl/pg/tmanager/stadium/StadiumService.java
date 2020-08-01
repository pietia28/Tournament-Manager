package pl.pg.tmanager.stadium;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.dtoMapping.dtoconvert.DtoConverter;
import pl.pg.tmanager.message.MessagesHandler;
import javax.validation.Validator;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Service
public class StadiumService {
    private final StadiumRepository stadiumRepository;
    private final Validator validator;
    private final MessagesHandler<Stadium> messagesHandler;
    private final DtoConverter<Stadium> dtoConverter;
    private Map<String, Object> response;

    public Map<String, Object> save(Stadium stadium) {
        return null;
    }

    public List<Map<String, Object>> findAll() {
        return dtoConverter.EntityToDtoAll(stadiumRepository.findAll());
    }

    public Map<String, Object> findById(Long id) {
        return null;
    }

    public Map<String, Object> delete(Long id) {
        return null;
    }

    public Long count() {
        return null;
    }
}
//TODO dodać logi
