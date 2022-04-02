package pl.saqie.InvoiceApp.app.common;

public class MissmatchPasswordException extends RuntimeException{

    public MissmatchPasswordException(String message) {
        super(message);
    }
}
