package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.PhoneNumberValidationException;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class NewCompanyController {

    private final NewCompanyUseCase newCompanyUseCase;

    @PreAuthorize("hasAnyAuthority('CLIENT','PENDING_CLIENT')")
    @GetMapping("/add/company")
    public String getNewCompanyForm(Model model){
        model.addAttribute(new NewCompanyDto());
        return "add-company";
    }

    @PreAuthorize("hasAnyAuthority('CLIENT','PENDING_CLIENT')")
    @PostMapping("/add/company")
    public String postNewCompanyForm(@ModelAttribute @Valid NewCompanyDto newCompanyDto, BindingResult bindingResult, @AuthenticationPrincipal Client client, Model model) throws PhoneNumberValidationException {
        if (!bindingResult.hasErrors()){
            newCompanyUseCase.addNewCompanyToClient(newCompanyDto, client);
            model.addAttribute("addedSuccessfully", "Pomyslnie dodano nowa firme do konta.");
        }
        return "add-company";
    }

}
