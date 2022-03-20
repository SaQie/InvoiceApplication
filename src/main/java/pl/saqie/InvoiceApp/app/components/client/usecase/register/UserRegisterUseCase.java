package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterUserDto;

public interface UserRegisterUseCase {

    void registerNewUser(RegisterUserDto registerUserDto);

}
