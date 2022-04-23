package pl.saqie.InvoiceApp.app.client.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.client.Role;
import pl.saqie.InvoiceApp.app.security.PasswordHasher;
import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;

import java.time.LocalDate;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class ClientMapper {

    private final PasswordHasher passwordHasher;

    public Client mapDtoToEntity(RegisterClientDto registerUserDto){
        return Client.builder()
                .username(registerUserDto.getUsername())
                .createdDate(LocalDate.now())
                .email(registerUserDto.getEmail())
                .password(passwordHasher.hash(registerUserDto.getPassword()))
                .role(Role.PENDING_CLIENT)
                .companies(new HashSet<>())
                .build();
    }

}
