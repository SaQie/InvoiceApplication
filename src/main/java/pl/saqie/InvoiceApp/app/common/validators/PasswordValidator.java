package pl.saqie.InvoiceApp.app.common.validators;

import pl.saqie.InvoiceApp.app.common.MissmatchPasswordException;

public interface PasswordValidator{

    void repeatPasswordValid(String password, String passwordRepeat) throws MissmatchPasswordException;

}
