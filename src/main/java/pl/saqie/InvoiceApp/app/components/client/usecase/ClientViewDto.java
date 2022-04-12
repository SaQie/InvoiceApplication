package pl.saqie.InvoiceApp.app.components.client.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.saqie.InvoiceApp.app.components.client.entity.Role;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientViewDto {

    private String username;
    private String email;
    private LocalDate createdDate;
    private Role role;
}
