package pl.saqie.InvoiceApp.app.components.company;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.client.entity.Role;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class NewCompanyController {

    private final CompanyService companyService;

    @PreAuthorize("hasAnyAuthority('CLIENT','PENDING_CLIENT')")
    @GetMapping("/add/company")
    public String getNewCompanyForm(Model model){
        model.addAttribute(new NewCompanyDto());
        return "add-company";
    }

    @PreAuthorize("hasAnyAuthority('CLIENT','PENDING_CLIENT')")
    @PostMapping("/add/company")
    public String postNewCompanyForm(@ModelAttribute @Valid NewCompanyDto companyDto, BindingResult bindingResult, @AuthenticationPrincipal Client client, Model model){
        if (!bindingResult.hasErrors()){
            companyService.createNewCompany(companyDto, client.getId());
            model.addAttribute("addedSuccessfully", "Pomyslnie dodano nowa firme do konta.");
        }
        return "add-company";
    }

}
