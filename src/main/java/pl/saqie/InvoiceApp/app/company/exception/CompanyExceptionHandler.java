package pl.saqie.InvoiceApp.app.company.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;

@ControllerAdvice
public class CompanyExceptionHandler {

    @ExceptionHandler(CompanyValidationException.class)
    public String handleNewCompanyExceptions(Model model, Exception exception){
        model.addAttribute("error", exception.getMessage());
        model.addAttribute(new NewCompanyDto());
        return "add-company";
    }
}
