package pl.saqie.InvoiceApp.app.components.company.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.saqie.InvoiceApp.app.components.client.ClientRepository;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.client.entity.Role;
import pl.saqie.InvoiceApp.app.components.company.CompanyRepository;
import pl.saqie.InvoiceApp.app.components.company.entity.Company;
import pl.saqie.InvoiceApp.app.components.company.mapper.CompanyMapper;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.NewCompanyValidator;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class NewCompanyUseCase {

    private final List<NewCompanyValidator> validator;
    private final CompanyRepository companyRepository;
    private final ClientRepository clientRepository;
    private final CompanyMapper companyMapper;

    public Company createNewCompany(NewCompanyDto newCompanyDto, Client client) {
        validCompanyFields(newCompanyDto);
        Company company = assignClientToCompany(mapFromDtoToEntity(newCompanyDto), client);
        return saveCompany(company);
    }

    private void validCompanyFields(NewCompanyDto newCompanyDto) {
        for (NewCompanyValidator newCompanyValidator : validator) {
            newCompanyValidator.check(newCompanyDto);
        }
    }

    private Company mapFromDtoToEntity(NewCompanyDto newCompanyDto) {
        return companyMapper.mapFromNewCompanyDtoToEntity(newCompanyDto);
    }

    private Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    private Company assignClientToCompany(Company company, Client entity) {
        checkNumberOfClientCompanies(entity);
        Client client = clientRepository.save(entity);
        company.setClient(client);
        return company;
    }

    private void checkNumberOfClientCompanies(Client entity) {
        if (entity.getNumberOfCompanies() == 0) {
            entity.setRole(Role.CLIENT);
        }
        entity.setNumberOfCompanies(entity.getNumberOfCompanies() + 1);
    }

}
