package pl.saqie.InvoiceApp.app.company.service.validator;

import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;

public interface NewCompanyValidator {

    void check(NewCompanyDto companyDto);

}
