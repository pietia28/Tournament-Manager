package pl.pg.tmanager.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudOperations<T> {

    void save(T t);
    List<T> findAll();
    Optional<T> findById(Long id);
    void delete(T t);
    Long count();
}
