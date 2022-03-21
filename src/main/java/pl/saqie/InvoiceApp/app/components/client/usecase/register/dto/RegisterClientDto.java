package pl.saqie.InvoiceApp.app.components.client.usecase.register.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterClientDto {

    @Size(min = 5, max = 15, message = "Nazwa musi skladac sie od 5 do 15 znakow.")
    private String username;
    @Email(message = "Wprowadz poprawny adres email")
    @NotEmpty(message = "Email nie moze pozostac pusty.")
    private String email;
    @Size(min = 5, max = 20, message = "Haslo musi zawierac od 5 do 20 znakow.")
    private String password;
    @NotEmpty(message = "To pole nie może pozostać puste.")
    private String passwordRepeat;

}
