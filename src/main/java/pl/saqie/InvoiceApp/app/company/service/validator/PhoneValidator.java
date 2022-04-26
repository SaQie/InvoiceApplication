package pl.saqie.InvoiceApp.app.company.service.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<PhoneValid, String> {

    private final String PATTERN = "^\\d{9}$";

    @Override
    public boolean isValid(String telephoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches(PATTERN, telephoneNumber);
    }
}
