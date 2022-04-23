package pl.saqie.InvoiceApp.app.client.service.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.client.repository.ClientRepository;
import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.client.exception.ClientExistsException;
import pl.saqie.InvoiceApp.app.client.exception.MissmatchPasswordException;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthValidator {

    private final ClientRepository clientRepository;

    public void validateClientFields(RegisterClientDto registerClientDto){
        if (clientRepository.existsByEmail(registerClientDto.getEmail())
                || clientRepository.existsByUsername(registerClientDto.getUsername())){
            throw new ClientExistsException("Taki klient juz istnieje.");
        }
        if (!Objects.equals(registerClientDto.getPassword(), registerClientDto.getPasswordRepeat())){
            throw new MissmatchPasswordException("Hasla nie sa zgodne.");
        }
    }

}
