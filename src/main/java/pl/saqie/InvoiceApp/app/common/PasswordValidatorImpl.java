package pl.saqie.InvoiceApp.app.common;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PasswordValidatorImpl implements PasswordValidator{

    @Override
    public void repeatPasswordValid(String password, String passwordRepeat) throws MissmatchPasswordException {
        if (!Objects.equals(password,passwordRepeat)){
            throw new MissmatchPasswordException("Hasla nie sa zgodne.");
        }
    }
}
