package pl.saqie.InvoiceApp.app.components.client.usecase.register.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.ClientExistsException;
import pl.saqie.InvoiceApp.app.components.client.ClientRepository;

@Service
@AllArgsConstructor
public class ClientUsernameExists implements RegisterValidator {

    private final ClientRepository clientRepository;

    @Override
    public void validate(RegisterClientDto registerUserDto){
        if (clientRepository.existsByUsername(registerUserDto.getUsername())){
            throw new ClientExistsException("Klient z nazwa " + registerUserDto.getUsername() + " juz istnieje.");
        }
    }
}
