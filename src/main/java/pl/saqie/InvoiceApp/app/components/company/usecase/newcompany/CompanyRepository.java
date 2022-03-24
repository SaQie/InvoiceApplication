package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.InvoiceApp.app.components.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
