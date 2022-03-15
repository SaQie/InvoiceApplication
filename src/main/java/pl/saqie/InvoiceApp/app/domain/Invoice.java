package pl.saqie.InvoiceApp.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private PaymentForm paymentForm;

    @ManyToOne
    private Company buyer;

    @OneToMany
    private List<Product> products;


}
