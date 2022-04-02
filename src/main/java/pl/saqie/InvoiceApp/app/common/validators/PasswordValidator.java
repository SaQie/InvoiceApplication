package pl.saqie.InvoiceApp.app.common.validators;

import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.common.MissmatchPasswordException;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;

import java.util.Objects;

@Service
public class PasswordValidator{

    public void valid(RegisterClientDto registerClientDto) throws MissmatchPasswordException {
        if (!Objects.equals(registerClientDto.getPassword(),registerClientDto.getPasswordRepeat())){
            throw new MissmatchPasswordException("Hasla nie sa zgodne.");
        }
    }
}
