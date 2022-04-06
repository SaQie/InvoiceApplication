package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator;

import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.PhoneNumberValidationException;

@Service
public class PhoneNumberValidatorImpl implements PhoneNumberValidator {

    @Override
    public void chceckPhoneNumberIsValid(String phoneNumber) throws PhoneNumberValidationException {
        boolean telephoneNumberCorrect = phoneNumber.matches("^\\d{9}$");
        if (!telephoneNumberCorrect){
            throw new PhoneNumberValidationException("Numer telefonu nie jest poprawny.");
        }
    }
}
