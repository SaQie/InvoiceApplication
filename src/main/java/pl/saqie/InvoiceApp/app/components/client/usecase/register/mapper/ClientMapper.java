package pl.saqie.InvoiceApp.app.components.client.usecase.register.mapper;

import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.Role;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;

import java.time.LocalDate;

public class ClientMapper {

    public static Client mapFromRegisterDtoToEntity(RegisterClientDto registerUserDto){
        return Client.builder()
                .username(registerUserDto.getUsername())
                .createdDate(LocalDate.now())
                .email(registerUserDto.getEmail())
                .password(registerUserDto.getPassword())
                .role(Role.PENDINGCLIENT)
                .build();
    }

}
