package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.Role;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterUserDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.mapper.ClientMapper;
import pl.saqie.InvoiceApp.app.repository.ClientRepository;
import pl.saqie.InvoiceApp.app.security.PasswordEncoder;

@Service
@AllArgsConstructor
public class UserRegisterUseCaseImpl implements UserRegisterUseCase {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerNewUser(RegisterUserDto registerUserDto) {
        Client client = ClientMapper.mapFromRegisterDtoToEntity(registerUserDto);
        client.setRole(Role.USER);
        hashUserPassword(client);
        clientRepository.save(client);
    }

    private void hashUserPassword(Client user) {
        String encodedPassword = passwordEncoder.getPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

}
