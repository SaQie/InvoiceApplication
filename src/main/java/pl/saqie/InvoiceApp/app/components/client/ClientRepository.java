package pl.saqie.InvoiceApp.app.components.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;

import java.util.Optional;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
