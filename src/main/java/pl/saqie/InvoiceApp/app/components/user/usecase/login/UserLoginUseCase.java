package pl.saqie.InvoiceApp.app.components.user.usecase.login;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.repository.ClientRepository;

@Service
@AllArgsConstructor
public class UserLoginUseCase implements UserDetailsService {

    private final ClientRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found."));
    }
}
