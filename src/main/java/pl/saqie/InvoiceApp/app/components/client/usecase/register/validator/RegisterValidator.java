package pl.saqie.InvoiceApp.app.components.client.usecase.register.validator;

import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.ClientExistsException;

public interface RegisterValidator {

    void validate(RegisterClientDto registerUserDto) throws ClientExistsException;

}
