package pl.pg.tmanager.dtoMapping.dtoconvert;

import org.hibernate.collection.internal.PersistentBag;
import org.springframework.stereotype.Component;
import pl.pg.tmanager.dtoMapping.annotation.Dto;
import pl.pg.tmanager.dtoMapping.annotation.HasForeignEntity;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DtoConverter<T> {

    public Map<String, Object> EntityToDto(T t) {

        Map<String, Object> result;
        result = getAnnotatesFields(t);
        List<String> foreignEntityNames = getForeignEntityNames(t);

        Map<String, Object> finalResult = result;
        foreignEntityNames.stream()
                .filter(f -> !f.isEmpty())
                .forEach(
                        f -> {
                            PersistentBag pb = (PersistentBag) finalResult.get(f);
                            String cName = pb.get(0).getClass().getCanonicalName();
                            try {
                                Class<?> c = Class.forName(cName);
                                List<Object>  foreignEntityDao = new ArrayList<>();
                                pb.forEach(
                                        p -> foreignEntityDao.add(c.cast(p))
                                );
                                finalResult.replace(f, getForeignEntityDto(foreignEntityDao));

                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                        }
                );

        return result;
    }

    private List<Map<String, Object>> getForeignEntityDto(List<Object> foreignEntityDto) {

        return foreignEntityDto.stream()
                .filter(Objects::nonNull)
                .map(this::getAnnotatesFields)
                .collect(Collectors.toList());
    }

    public T DtoToEntity(Object object, T t) {

        Class<?> entityClass = t.getClass();
        Class<?> dtoClass = object.getClass();

        Arrays.asList(entityClass.getDeclaredFields())
        .forEach(
                f -> {
                    f.setAccessible(true);
                    try {
                        Field dtoField = dtoClass.getDeclaredField(f.getName());
                        dtoField.setAccessible(true);
                        f.set(t, dtoField.get(object));
                        f.setAccessible(false);
                        dtoField.setAccessible(false);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
        );

        return t;
    }

    public List<Map<String, Object>> EntityToDtoAll(List<T> t) {

        return t.stream()
                .map(this::EntityToDto)
                .collect(Collectors.toList());

    }

    private Map<String, Object> getAnnotatesFields(Object o) {

        Class<?> entityClass = o.getClass();
        Map<String, Object> dtoMap = new HashMap<>();

        Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Dto.class))
                .collect(Collectors.toList())
                .forEach(
                        a -> {
                            try {
                                a.setAccessible(true);
                                dtoMap.put(a.getName(), a.get(o));
                                a.setAccessible(false);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                );
        return dtoMap;
    }

    private List<String> getForeignEntityNames(T t) {

        Class<?> entityClass = t.getClass();
        List<Annotation> annotations = Arrays.asList(entityClass.getAnnotations());
        List<String> entityNamesList = new ArrayList<>();

        annotations.stream()
                .filter(a -> a instanceof HasForeignEntity)
                .forEach(
                        a -> entityNamesList.addAll(Arrays.asList(((HasForeignEntity) a).entityName()))
                );
        return entityNamesList;
    }
}
