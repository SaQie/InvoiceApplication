package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.company.CompanyRepository;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.CompanyValidationException;

@Service
@AllArgsConstructor
public class CompanyExistsChain implements NewCompanyValidator{

    private final CompanyRepository companyRepository;

    @Override
    public void check(NewCompanyDto companyDto) {
        if (companyRepository.existsByName(companyDto.getName())){
            throw new CompanyValidationException("Firma z podana nazwa juz istnieje");
        }
        if (companyRepository.existsByAdress(companyDto.getAdress())){
            throw new CompanyValidationException("Firma z podanym adresem juz istnieje");
        }
        if (companyRepository.existsByNip(companyDto.getNip())){
            throw new CompanyValidationException("Firma z podanym numerem nip juz istnieje");
        }
        if (companyRepository.existsByRegon(companyDto.getRegon())){
            throw new CompanyValidationException("Firma z podanym numerem regon juz istnieje");
        }
    }
}
