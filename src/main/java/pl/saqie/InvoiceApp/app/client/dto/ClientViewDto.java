package pl.saqie.InvoiceApp.app.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.saqie.InvoiceApp.app.client.Role;

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
