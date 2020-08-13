package pl.pg.tmanager.exception;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    ResponseErrorDetails handleRecordNotFoundException(ObjectNotFoundException ex) {
        return ResponseErrorDetails.builder()
                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                .status(HttpStatus.NOT_FOUND.value())
                .description(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = new HashMap<>();
        List<String> propertyPaths = getErrorsPropertyPath(ex);
        propertyPaths.forEach(
                p -> errors.put(p, getErrorsMessages(ex, p))
        );
        return errors;
    }

    private List<String> getErrorsPropertyPath(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .map(e -> ((FieldError) e).getField())
                .distinct()
                .collect(Collectors.toList());
    }

    private List<String> getErrorsMessages(MethodArgumentNotValidException ex, String propertyPath) {
        return ex.getBindingResult().getAllErrors().stream()
                .filter(e -> propertyPath.equals(((FieldError) e).getField()))
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .sorted()
                .collect(Collectors.toList());
    }
}
