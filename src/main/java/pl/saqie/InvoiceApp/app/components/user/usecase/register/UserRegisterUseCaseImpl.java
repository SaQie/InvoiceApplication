package pl.saqie.InvoiceApp.app.components.user.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.user.usecase.register.dto.RegisterUserDto;
import pl.saqie.InvoiceApp.app.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserRegisterUseCaseImpl implements UserRegisterUseCase {

    private final UserRepository userRepository;

    @Override
    public void registerNewUser(RegisterUserDto registerUserDto) {

    }
}
