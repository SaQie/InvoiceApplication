package pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.saqie.InvoiceApp.app.common.MissmatchPasswordException;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;

@ControllerAdvice
public class RegisterExceptionHandler {

    @ExceptionHandler({ClientExistsException.class, MissmatchPasswordException.class})
    public String handleRegisterExceptions(Model model, Exception exception){
        model.addAttribute("error", exception.getMessage());
        model.addAttribute(new RegisterClientDto());
        return "register";
    }

}
