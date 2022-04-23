package pl.saqie.InvoiceApp.app.client;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.InvoiceApp.app.client.service.ClientAuthService;
import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AuthController {

    private final ClientAuthService service;

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(@AuthenticationPrincipal Client client, Model model){
        if (client == null) {
            model.addAttribute(new RegisterClientDto());
            return "register";
        }
        return "redirect:/home";
    }

    @PostMapping("/register")
    public String processRegisterNewUser(@ModelAttribute @Valid RegisterClientDto clientDto, BindingResult bindingResult, Model model, HttpServletRequest request) throws ServletException {
        if (!bindingResult.hasErrors()){
            service.registerNewClient(clientDto);
            request.login(clientDto.getUsername(), clientDto.getPasswordRepeat());
            model.addAttribute("registeredSuccessfully", "Zostales pomyslnie zarejestrowany.");
        }
        return "register";
    }


}
