package pl.saqie.InvoiceApp.app.client.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class RegisterClientDto {

    @Size(min = 3, max = 15, message = "Nazwa musi skladac sie od 3 do 15 znakow.")
    @NotBlank(message = "Pole nie moze zawierac bialych znakow")
    private String username;
    @Email(message = "Wprowadz poprawny adres email")
    @NotEmpty(message = "Email nie moze pozostac pusty.")
    private String email;
    @Size(min = 5, max = 20, message = "Haslo musi zawierac od 5 do 20 znakow.")
    @NotBlank(message = "Haslo nie moze zawierac bialych znakow")
    private String password;
    @NotEmpty(message = "To pole nie może pozostać puste.")
    @NotBlank(message = "Haslo nie moze zawierac bialych znakow")
    private String passwordRepeat;
}
