package pl.saqie.InvoiceApp.app.common;

public interface PasswordValidator {

    void repeatPasswordValid(String password, String passwordRepeat) throws MissmatchPasswordException;

}
