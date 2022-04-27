package pl.saqie.InvoiceApp.app.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.client.dto.ClientViewDto;

import java.util.Optional;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
