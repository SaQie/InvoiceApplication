package pl.saqie.InvoiceApp.app.company.dto;

import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;
import pl.saqie.InvoiceApp.app.company.service.validator.CompanyExists;
import pl.saqie.InvoiceApp.app.company.service.validator.PhoneValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CompanyExists(message = "Taka firma juz istnieje.")
public class NewCompanyDto {

    @Size(min = 3,message = "Nazwa firmy musi zawierac co najmniej 3 znaki")
    private String name;
    @NotEmpty(message = "Pole nie moze pozostac puste")
    @NotBlank(message = "Pole nie moze zawierac bialych znakow")
    private String adress;
    @PhoneValid(message = "Wprowadz poprawny numer telefonu.")
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
