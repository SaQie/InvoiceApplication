package pl.saqie.InvoiceApp.app.company.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.saqie.InvoiceApp.app.client.service.ClientAuthService;
import pl.saqie.InvoiceApp.app.client.repository.ClientRepository;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.client.Role;
import pl.saqie.InvoiceApp.app.company.Company;
import pl.saqie.InvoiceApp.app.company.mapper.CompanyMapper;
import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.company.service.validator.NewCompanyValidator;

import java.util.List;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class NewCompanyUseCase {

    private final List<NewCompanyValidator> validator;
    private final ClientRepository clientRepository;
    private final ClientAuthService clientService;
    private final CompanyMapper companyMapper;

    public Company createNewCompany(NewCompanyDto newCompanyDto, Long clientId) {
        validCompanyFields(newCompanyDto);
        Client client = clientRepository.getById(clientId);
        return assignClientToCompany(mapFromDtoToEntity(newCompanyDto), client);
    }

    private void validCompanyFields(NewCompanyDto newCompanyDto) {
        for (NewCompanyValidator newCompanyValidator : validator) {
            newCompanyValidator.check(newCompanyDto);
        }
    }

    private Company mapFromDtoToEntity(NewCompanyDto newCompanyDto) {
        return companyMapper.mapFromNewCompanyDtoToEntity(newCompanyDto);
    }


    private Company assignClientToCompany(Company company, Client entity) {
        addCompany(entity,company);
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
