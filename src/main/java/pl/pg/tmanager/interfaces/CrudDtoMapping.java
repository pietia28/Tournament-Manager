package pl.pg.tmanager.interfaces;

import java.util.List;
import java.util.Map;

public interface CrudDtoMapping<T> {

    Map<String, Object> save(T t);
    List<Map<String, Object>> findAll();
    Map<String, Object> findById(Long id);
    Map<String, Object> delete(Long id);
    Long count();
}
