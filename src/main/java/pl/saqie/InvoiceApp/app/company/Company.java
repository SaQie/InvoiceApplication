package pl.saqie.InvoiceApp.app.company;

import lombok.*;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.invoice.Invoice;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String adress;
    private String nip;
    private String regon;
    private String phoneNumber;
    private String ownerName;
    private String ownerLastName;

    @OneToMany
    private Set<Invoice> invoices;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
