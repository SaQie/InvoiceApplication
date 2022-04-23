package pl.saqie.InvoiceApp.app.client.exception;

public class ClientExistsException extends RuntimeException{

    public ClientExistsException(String message) {
        super(message);
    }
}
