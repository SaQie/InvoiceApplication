package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.common.MissmatchPasswordException;
import pl.saqie.InvoiceApp.app.common.validators.PasswordValidator;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.RegisterValidator;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.ClientExistsException;

import java.util.List;

@Service
@AllArgsConstructor
public class Validator {

    private final PasswordValidator passwordValidator;
    private final List<RegisterValidator> validators;

    public void validateClient(RegisterClientDto registerClientDto) throws ClientExistsException, MissmatchPasswordException {
        for (RegisterValidator registerValidator : validators) {
            registerValidator.validate(registerClientDto);
        }
        passwordValidator.valid(registerClientDto);
    }

}
