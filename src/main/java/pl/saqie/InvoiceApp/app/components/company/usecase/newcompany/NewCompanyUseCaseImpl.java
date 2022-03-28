package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.PhoneNumberValidationException;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.CorrectPhoneNumberValidator;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.company.Company;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.mapper.CompanyMapper;

@Service
@AllArgsConstructor
public class NewCompanyUseCaseImpl implements NewCompanyUseCase{

    private final CompanyRepository companyRepository;
    private final CorrectPhoneNumberValidator correctPhoneNumberValidator;

    @Override
    public void addNewCompanyToClient(NewCompanyDto newCompanyDto, Client client) throws PhoneNumberValidationException {
        validPhoneNumber(newCompanyDto.getTelephoneNumber());
        Company company = CompanyMapper.mapFromNewCompanyDtoToEntity(newCompanyDto);
        company.setClient(client);
        companyRepository.save(company);
    }

    private void validPhoneNumber(String number) throws PhoneNumberValidationException {
        correctPhoneNumberValidator.chceckPhoneNumberIsValid(number);
    }

}
