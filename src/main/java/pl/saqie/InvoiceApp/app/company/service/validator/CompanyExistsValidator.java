package pl.saqie.InvoiceApp.app.company.service.validator;

import lombok.AllArgsConstructor;
import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.company.repository.CompanyRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class CompanyExistsValidator implements ConstraintValidator<CompanyExists, NewCompanyDto> {

    private final CompanyRepository companyRepository;

    @Override
    public boolean isValid(NewCompanyDto company, ConstraintValidatorContext constraintValidatorContext) {
        return !companyRepository.existsByAdress(company.getAdress()) && !companyRepository.existsByName(company.getName()) && !companyRepository.existsByNip(company.getNip()) && !companyRepository.existsByRegon(company.getRegon());
    }
}
