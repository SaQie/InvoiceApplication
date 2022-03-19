package pl.saqie.InvoiceApp.app;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/home")
    public String getAnonymousHomePage(){
        return "home";
    }

    @GetMapping("/")
    public String redirectToHomePage(){
        return "redirect:/home";
    }

    @PostMapping("/")
    public String redirectToHomePageFromSuccessLogin(){
        return "redirect:/home";
    }

    @GetMapping("/accessdenied")
    public String accesDeniedPage(){
        return "accessdenied";
    }

    @PostMapping("/accessdenied")
    public String asd(){
        return "redirect:/accessdenied";
    }

}
