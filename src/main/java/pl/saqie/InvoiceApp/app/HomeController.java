package pl.saqie.InvoiceApp.app;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public String getAnonymousHomePage(){
        return "home";
    }

    @GetMapping("/")
    public String redirectToHomePage(){
        return "redirect:/home";
    }

}
