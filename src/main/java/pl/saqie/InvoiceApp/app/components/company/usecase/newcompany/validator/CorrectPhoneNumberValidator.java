package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator;

import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.PhoneNumberValidationException;

public interface CorrectPhoneNumberValidator{

    void chceckPhoneNumberIsValid(String phoneNumber) throws PhoneNumberValidationException;

}
