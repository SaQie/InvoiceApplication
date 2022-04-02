package pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception;

public class ClientExistsException extends RuntimeException{

    public ClientExistsException(String message) {
        super(message);
    }
}
