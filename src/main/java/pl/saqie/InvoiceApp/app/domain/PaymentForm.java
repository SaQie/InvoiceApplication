package pl.saqie.InvoiceApp.app.domain;

public enum PaymentForm {

    TRANSFER("Przelew bankowy"),
    CASH("Gotówka");

    private String description;

    PaymentForm(String description) {
        this.description = description;
    }
}
