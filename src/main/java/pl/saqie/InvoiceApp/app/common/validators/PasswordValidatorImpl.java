package pl.saqie.InvoiceApp.app.common.validators;

import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.common.MissmatchPasswordException;

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
