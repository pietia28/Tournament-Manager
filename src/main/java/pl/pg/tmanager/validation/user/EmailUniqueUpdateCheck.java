package pl.pg.tmanager.validation.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueUpdateCheck implements ConstraintValidator<EmailUniqueUpdate, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

    @Override
    public void initialize(EmailUniqueUpdate constraintAnnotation) {

    }
}
