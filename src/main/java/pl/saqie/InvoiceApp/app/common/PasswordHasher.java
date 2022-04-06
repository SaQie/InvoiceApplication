package pl.saqie.InvoiceApp.app.common;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.security.PasswordEncoder;

@Component
@AllArgsConstructor
public class PasswordHasher {

    private final PasswordEncoder passwordEncoder;

    public String hash(String password){
        return passwordEncoder.getPasswordEncoder().encode(password);
    }

}
