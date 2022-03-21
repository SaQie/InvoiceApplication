package pl.saqie.InvoiceApp.app.components.company;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CompanyController {

    @PreAuthorize("hasAuthority('PENDINGCLIENT') || hasAuthority('CLIENT')")
    @GetMapping("/add/company")
    public String getNewCompanyForm(Model model){
        return "add-company";
    }

}
