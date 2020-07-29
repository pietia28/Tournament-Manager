package pl.pg.tmanager.stadium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pg.tmanager.dtoMapping.dtoconvert.DtoConverter;
import pl.pg.tmanager.interfaces.CrudDtoMapping;
import pl.pg.tmanager.message.MessagesHandler;
import javax.validation.Validator;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StadiumService implements CrudDtoMapping<Stadium> {
    private final StadiumRepository stadiumRepository;
    private final Validator validator;
    private final MessagesHandler<Stadium> messagesHandler;
    private final DtoConverter<Stadium> dtoConverter;
    private Map<String, Object> response;

    public StadiumService(StadiumRepository stadiumRepository, Validator validator,
                          MessagesHandler<Stadium> messagesHandler,
                          DtoConverter<Stadium> dtoConverter) {
        this.stadiumRepository = stadiumRepository;
        this.validator = validator;
        this.messagesHandler = messagesHandler;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public Map<String, Object> save(Stadium stadium) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return dtoConverter.EntityToDtoAll(stadiumRepository.findAll());
    }

    @Override
    public Map<String, Object> findById(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }
}
//TODO dodać logi
