package pl.pg.tmanager.validation.user;

import lombok.RequiredArgsConstructor;
import pl.pg.tmanager.user.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class NickUniqueCheck implements ConstraintValidator<NickUnique, String> {
    private final UserRepository userRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByNick(s) == null;
    }

    @Override
    public void initialize(NickUnique constraintAnnotation) {

    }
}
