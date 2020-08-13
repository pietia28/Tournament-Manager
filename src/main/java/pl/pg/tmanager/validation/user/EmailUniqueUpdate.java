package pl.pg.tmanager.validation.user;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailUniqueCheck.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUniqueUpdate {
    String message() default "Exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
