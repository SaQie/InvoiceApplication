package pl.saqie.InvoiceApp.app.client.service.validator;

import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValid, RegisterClientDto> {

    @Override
    public boolean isValid(RegisterClientDto registerClientDto, ConstraintValidatorContext constraintValidatorContext) {
        if (!registerClientDto.getPassword().isBlank()){
            return registerClientDto.getPassword().equals(registerClientDto.getPasswordRepeat());
        }
        return false;
    }
}
