package pl.saqie.InvoiceApp.app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.UserRegisterUseCase;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterUserDto;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final UserRegisterUseCase registerUseCase;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute(new RegisterUserDto());
        return "register";
    }

    @PostMapping("/register")
    public String processRegisterNewUser(@ModelAttribute @Valid RegisterUserDto registerUserDto){
        registerUseCase.registerNewUser(registerUserDto);
        return "asd";
    }

}
