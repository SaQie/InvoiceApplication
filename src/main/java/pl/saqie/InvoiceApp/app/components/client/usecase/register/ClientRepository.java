package pl.saqie.InvoiceApp.app.components.client.usecase.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.InvoiceApp.app.components.client.Client;

import java.util.Optional;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
