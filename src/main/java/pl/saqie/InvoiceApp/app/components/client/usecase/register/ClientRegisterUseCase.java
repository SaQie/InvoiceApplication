package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.ClientRepository;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.mapper.ClientMapper;

@Service
@AllArgsConstructor
public class ClientRegisterUseCase{

    private final PasswordHasher passwordHasher;
    private final Validator validator;
    private final ClientRepository clientRepository;

    public Client registerNewClient(RegisterClientDto registerClientDto){
        validator.validateClient(registerClientDto);
        hashUserPassword(registerClientDto);
        Client client = ClientMapper.mapFromRegisterDtoToEntity(registerClientDto);
        return clientRepository.save(client);
    }

    private void hashUserPassword(RegisterClientDto registerClientDto) {
        String hashedPassword = passwordHasher.hash(registerClientDto.getPassword());
        registerClientDto.setPassword(hashedPassword);
    }


}
