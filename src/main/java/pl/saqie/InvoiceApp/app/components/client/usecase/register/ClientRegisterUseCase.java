package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import pl.saqie.InvoiceApp.app.common.MissmatchPasswordException;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.ClientExistsException;

public interface ClientRegisterUseCase {

    void registerNewUser(RegisterClientDto registerClientDto) throws ClientExistsException, MissmatchPasswordException;

}
