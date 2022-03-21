package pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception;

public class ClientExistsException extends Exception{

    public ClientExistsException(String message) {
        super(message);
    }
}
