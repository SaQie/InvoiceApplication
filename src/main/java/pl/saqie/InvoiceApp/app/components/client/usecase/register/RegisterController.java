package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final ClientRegisterUseCase registerUseCase;

    @GetMapping("/register")
    public String getRegisterPage(@AuthenticationPrincipal Client client, Model model){
        if (client == null) {
            model.addAttribute(new RegisterClientDto());
            return "register";
        }
        return "redirect:/home";
    }

    @PostMapping("/register")
    public String processRegisterNewUser(@ModelAttribute @Valid RegisterClientDto registerClientDto, BindingResult bindingResult, Model model, HttpServletRequest request) throws ServletException {
        if (!bindingResult.hasErrors()){
            registerUseCase.registerNewClient(registerClientDto);
            request.login(registerClientDto.getUsername(), registerClientDto.getPasswordRepeat());
            model.addAttribute("registeredSuccessfully", "Zostales pomyslnie zarejestrowany.");
        }
        return "register";
    }

}
