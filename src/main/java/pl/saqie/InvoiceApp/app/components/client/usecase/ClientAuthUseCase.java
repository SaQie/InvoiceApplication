package pl.saqie.InvoiceApp.app.components.client.usecase;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.client.ClientRepository;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.mapper.ClientMapper;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.RegisterValidator;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientAuthUseCase implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final List<RegisterValidator> validators;
    private final ClientMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Client with name " + username + " not found."));
    }

    public Client registerClient(RegisterClientDto clientDto){
        validateClientFields(clientDto);
        Client client = mapFromDtoToEntity(clientDto);
        return saveClient(client);
    }

    private void validateClientFields(RegisterClientDto clientDto) {
        for (RegisterValidator validator : validators) {
            validator.validate(clientDto);
        }
    }

    private Client mapFromDtoToEntity(RegisterClientDto clientDto) {
        return mapper.mapDtoToEntity(clientDto);
    }

    private Client saveClient(Client client) {
        return clientRepository.save(client);
    }


}
