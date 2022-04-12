package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator;

import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.CompanyValidationException;

@Service
public class PhoneCorrectChain implements NewCompanyValidator {

    @Override
    public void check(NewCompanyDto companyDto){
        boolean telephoneNumberCorrect = companyDto.getTelephoneNumber().matches("^\\d{9}$");
        if (!telephoneNumberCorrect){
            throw new CompanyValidationException("Numer telefonu nie jest poprawny.");
        }
    }
}
