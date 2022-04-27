package pl.saqie.InvoiceApp.app.company.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.company.Company;
import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CreateCompanyService companyService;

    public Company createNewCompany(NewCompanyDto companyDto, Long clientId){
        return companyService.createNewCompany(companyDto, clientId);
    }



}
