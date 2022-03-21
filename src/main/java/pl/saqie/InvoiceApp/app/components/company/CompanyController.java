package pl.saqie.InvoiceApp.app.components.company;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.NewCompanyDto;

@Controller
@AllArgsConstructor
public class CompanyController {

    @PreAuthorize("hasAuthority('PENDINGCLIENT') || hasAuthority('CLIENT')")
    @GetMapping("/add/company")
    public String getNewCompanyForm(Model model){
        model.addAttribute(new NewCompanyDto());
        return "add-company";
    }

}
