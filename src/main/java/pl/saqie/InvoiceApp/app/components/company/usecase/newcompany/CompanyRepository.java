package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.saqie.InvoiceApp.app.components.company.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
