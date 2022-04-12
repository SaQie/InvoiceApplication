package pl.saqie.InvoiceApp.app.components.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.client.usecase.ClientAuthUseCase;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientAuthUseCase clientAuthUseCase;

    public Client register(RegisterClientDto clientDto){
        return clientAuthUseCase.registerClient(clientDto);
    }

    public void reloadUserRole(){
        clientAuthUseCase.reloadRole();
    }



}
