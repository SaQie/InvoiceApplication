package pl.saqie.InvoiceApp.app.components.company;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.client.ClientService;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.company.entity.Company;
import pl.saqie.InvoiceApp.app.components.company.usecase.NewCompanyUseCase;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;

@Service
@AllArgsConstructor
public class CompanyService {

    private final NewCompanyUseCase newCompanyUseCase;
    private final ClientService clientService;

    public Company createNewCompany(NewCompanyDto companyDto, Client client){
        return newCompanyUseCase.createNewCompany(companyDto, client);
    }

    public void reloadClientRole(Client client){
        if (client.getNumberOfCompanies() == 1) {
            clientService.reloadUserRole();
        }
    }

}
