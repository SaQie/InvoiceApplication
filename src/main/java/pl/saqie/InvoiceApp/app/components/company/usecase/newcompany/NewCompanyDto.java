package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany;

import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewCompanyDto {

    @Size(min = 3,message = "Nazwa firmy musi zawierac co najmniej 3 znaki")
    private String name;
    @NotEmpty(message = "Pole nie moze pozostac puste")
    private String adress;
    @Size(min = 9, max = 9, message = "Podaj poprawny numer telefonu")
    private String telephoneNumber;
    @NIP(message = "Wprowadz poprawny numer NIP")
    private String nip;
    @REGON(message = "Wprowadz poprawny numer REGON")
    private String regon;


}