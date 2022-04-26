package pl.saqie.InvoiceApp.app.company.exception;

public class CompanyValidationException extends RuntimeException{

    public CompanyValidationException(String message) {
        super(message);
    }
}
