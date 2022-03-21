package pl.saqie.InvoiceApp.app.common;

public class MissmatchPasswordException extends Exception{

    public MissmatchPasswordException(String message) {
        super(message);
    }
}
