package pl.saqie.InvoiceApp.app.domain;

public enum VatValue {

    BASIC_RATE("23%"),
    REDUCED_RATE_8("8%"),
    REDUCED_RATE_5("5%"),
    REDUCED_RATE_0("0%");

    private String description;

    VatValue(String description) {
        this.description = description;
    }
}
