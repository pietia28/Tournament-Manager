package pl.pg.tmanager.validation.user;

import lombok.RequiredArgsConstructor;
import pl.pg.tmanager.user.UserRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailUniqueCheck implements ConstraintValidator<EmailUnique, String> {
    private final UserRepository userRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByEmail(s) == null;
    }

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }
}
