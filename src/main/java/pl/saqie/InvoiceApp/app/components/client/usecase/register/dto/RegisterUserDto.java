package pl.saqie.InvoiceApp.app.components.client.usecase.register.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    private String username;
    private String email;
    private String password;
    private String passwordRepeat;

}
