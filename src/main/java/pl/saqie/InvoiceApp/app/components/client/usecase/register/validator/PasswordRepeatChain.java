package pl.saqie.InvoiceApp.app.components.client.usecase.register.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.ClientExistsException;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.MissmatchPasswordException;

import java.util.Objects;

@Service
@AllArgsConstructor
public class PasswordRepeatChain implements RegisterValidator {

    @Override
    public void validate(RegisterClientDto clientDto) throws ClientExistsException {
        if (!Objects.equals(clientDto.getPassword(), clientDto.getPasswordRepeat())) {
            throw new MissmatchPasswordException("Hasla nie sa zgodne.");
        }
    }
}
