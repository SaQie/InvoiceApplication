package pl.saqie.InvoiceApp.app.components.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.client.usecase.ClientViewDto;

import java.util.Optional;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    @Query("select new pl.saqie.InvoiceApp.app.components.client.usecase.ClientViewDto(c.username, c.email, c.createdDate, c.role) from Client c where c.id = :id")
    Optional<ClientViewDto> searchById(Long id);
}
