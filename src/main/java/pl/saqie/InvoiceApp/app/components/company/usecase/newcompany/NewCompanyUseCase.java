package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.ClientRepository;
import pl.saqie.InvoiceApp.app.components.client.Role;
import pl.saqie.InvoiceApp.app.components.company.Company;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.mapper.CompanyMapper;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.CorrectPhoneNumberValidator;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.PhoneNumberValidationException;

@Service
@Transactional
@AllArgsConstructor
public class NewCompanyUseCase{

    private final CorrectPhoneNumberValidator correctPhoneNumberValidator;
    private final ClientRepository clientRepository;
    private final CompanyRepository companyRepository;

    public void addNewCompanyToClient(NewCompanyDto newCompanyDto, Client client) throws PhoneNumberValidationException {
        validPhoneNumber(newCompanyDto.getTelephoneNumber());
        Company company = mapDtoToCompany(newCompanyDto, client);
        companyRepository.save(company);
    }


    private void validPhoneNumber(String number) throws PhoneNumberValidationException {
        correctPhoneNumberValidator.chceckPhoneNumberIsValid(number);
    }

    private Company mapDtoToCompany(NewCompanyDto newCompanyDto, Client client){
        Company company = CompanyMapper.mapFromNewCompanyDtoToEntity(newCompanyDto);
        client.setRole(Role.CLIENT);
        client.setNumberOfCompanies(client.getNumberOfCompanies() + 1);
        Client save = clientRepository.save(client);
        company.setClient(save);
        return company;
    }



}
