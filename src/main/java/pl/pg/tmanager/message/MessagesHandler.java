package pl.pg.tmanager.message;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class MessagesHandler<T> {

    public Map<String, List<String>> getValidationMessage(Validator validator, T t) {

        Map<String, List<String>> errorsMap = new HashMap<>();
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        List<String> errorsPathList = getErrorsPropertyPath(violations);
        errorsPathList.forEach(
                e -> errorsMap.put(e, getErrorsMessages(violations, e))
        );
        return errorsMap;
    }

   private List<String> getErrorsPropertyPath(Set<ConstraintViolation<T>> violations) {

        return violations.stream()
                .map(e -> e.getPropertyPath().toString())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
   }

   private List<String> getErrorsMessages(Set<ConstraintViolation<T>> violations, String value) {
        return violations.stream()
                .filter(e -> value.equals(e.getPropertyPath().toString()))
                .map(ConstraintViolation::getMessage)
                .sorted()
                .collect(Collectors.toList());
   }
}
