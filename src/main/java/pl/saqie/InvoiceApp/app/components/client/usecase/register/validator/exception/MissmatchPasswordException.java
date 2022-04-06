package pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception;

public class MissmatchPasswordException extends RuntimeException{

    public MissmatchPasswordException(String message) {
        super(message);
    }
}
