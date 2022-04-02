package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.security.PasswordEncoder;

@Service
@AllArgsConstructor
public class PasswordHasher {

    private final PasswordEncoder passwordEncoder;

    public String hash(String password){
        return passwordEncoder.getPasswordEncoder().encode(password);
    }

}
