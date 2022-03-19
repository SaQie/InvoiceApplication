package pl.saqie.InvoiceApp.app.components.user.usecase.register.mapper;

import pl.saqie.InvoiceApp.app.components.user.Client;
import pl.saqie.InvoiceApp.app.components.user.usecase.register.dto.RegisterUserDto;

import java.time.LocalDate;

public class ClientMapper {

    public static Client mapFromRegisterDtoToEntity(RegisterUserDto registerUserDto){
        return Client.builder()
                .username(registerUserDto.getUsername())
                .createdDate(LocalDate.now())
                .email(registerUserDto.getEmail())
                .password(registerUserDto.getPassword())
                .build();
    }

}
