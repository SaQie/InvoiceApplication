package pl.saqie.InvoiceApp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.InvoiceApp.app.domain.User;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
