package pl.saqie.InvoiceApp.app.components.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.saqie.InvoiceApp.app.domain.VatValue;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String unit;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private VatValue VAT;

}
