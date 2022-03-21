package pl.saqie.InvoiceApp.app.components.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.saqie.InvoiceApp.app.components.invoice.Invoice;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String adress;
    private String nip;
    private String regon;
    private String phoneNumber;

    @OneToMany
    private List<Invoice> invoices;

}
