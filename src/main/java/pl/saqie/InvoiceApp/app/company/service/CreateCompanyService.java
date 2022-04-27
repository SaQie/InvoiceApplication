package pl.saqie.InvoiceApp.app.company.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.client.Role;
import pl.saqie.InvoiceApp.app.client.repository.ClientRepository;
import pl.saqie.InvoiceApp.app.client.service.ClientAuthService;
import pl.saqie.InvoiceApp.app.company.Company;
import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.company.mapper.CompanyMapper;

import java.util.Set;

@Service
@AllArgsConstructor
public class CreateCompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateCompanyService.class);
    private final ClientRepository clientRepository;
    private final ClientAuthService clientService;
    private final CompanyMapper companyMapper;

    public Company createNewCompany(NewCompanyDto companyDto, Long clientId){
        LOGGER.info("Adding new company to database ( " + companyDto + " )");
        Client client = clientRepository.getById(clientId);
        Company companyBeforeAddClient = companyMapper.mapFromNewCompanyDtoToEntity(companyDto);
        Company companyAfterAddClient = assignClientToCompany(companyBeforeAddClient, client);
        return companyAfterAddClient;
    }

    private Company assignClientToCompany(Company company, Client client) {
        addCompany(client,company);
        return company;
    }

    private void addCompany(Client client, Company companyToAdd){
        checkNumberOfClientCompanies(client);
        Set<Company> companies = client.getCompanies();
        companyToAdd.setClient(client);
        companies.add(companyToAdd);
        client.setCompanies(companies);
        clientRepository.save(client);
    }

    private void checkNumberOfClientCompanies(Client entity) {
        if (entity.getNumberOfCompanies() == 0) {
            entity.setRole(Role.CLIENT);
            clientService.reloadClientRole();
        }
    }

}
