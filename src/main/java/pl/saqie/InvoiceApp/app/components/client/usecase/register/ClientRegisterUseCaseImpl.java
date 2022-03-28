package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.common.MissmatchPasswordException;
import pl.saqie.InvoiceApp.app.common.validators.PasswordValidator;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.ClientRepository;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.mapper.ClientMapper;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.RegisterValidator;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.ClientExistsException;
import pl.saqie.InvoiceApp.app.security.PasswordEncoder;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientRegisterUseCaseImpl implements ClientRegisterUseCase {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final List<RegisterValidator> validatorList;
    private final PasswordValidator passwordValidator;

    @Override
    public void registerNewUser(RegisterClientDto registerClientDto) throws ClientExistsException, MissmatchPasswordException {
        validateClient(registerClientDto);
        Client client = ClientMapper.mapFromRegisterDtoToEntity(registerClientDto);
        hashUserPassword(client);
        clientRepository.save(client);
    }

    private void validateClient(RegisterClientDto registerClientDto) throws ClientExistsException, MissmatchPasswordException {
        for (RegisterValidator registerValidator : validatorList) {
            registerValidator.validate(registerClientDto);
        }
        passwordValidator.repeatPasswordValid(registerClientDto.getPassword(), registerClientDto.getPasswordRepeat());
    }

    private void hashUserPassword(Client user) {
        String encodedPassword = passwordEncoder.getPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

}
