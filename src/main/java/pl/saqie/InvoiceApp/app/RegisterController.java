package pl.saqie.InvoiceApp.app;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RegisterController {

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

}
