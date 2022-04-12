package pl.saqie.InvoiceApp.app.components.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.InvoiceApp.app.components.company.entity.Company;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByName(String name);

    boolean existsByAdress(String adress);

    boolean existsByRegon(String regon);

    boolean existsByNip(String nip);

}
