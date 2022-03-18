package pl.saqie.InvoiceApp.app.components.user.usecase.register;

import pl.saqie.InvoiceApp.app.components.user.usecase.register.dto.RegisterUserDto;

public interface UserRegisterUseCase {

    void registerNewUser(RegisterUserDto registerUserDto);

}
