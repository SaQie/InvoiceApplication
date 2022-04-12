package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto;

import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Pole nie moze zawierac bialych znakow")
    private String adress;
    @Size(min = 9, max = 9, message = "Podaj poprawny numer telefonu")
    @NotBlank(message = "Pole nie moze zawierac bialych znakow")
    private String telephoneNumber;
    @NIP(message = "Wprowadz poprawny numer NIP")
    private String nip;
    @REGON(message = "Wprowadz poprawny numer REGON")
    private String regon;
    @NotBlank(message = "Pole nie może być puste.")
    @Size(min = 2, message = "Pole musi zawierać co najmniej 2 znaki.")
    private String ownerName;
    @NotBlank(message = "Pole nie może być puste.")
    @Size(min = 2, message = "Pole musi zawierać co najmniej 2 znaki.")
    private String ownerLastName;

    private Long clientId;

}
