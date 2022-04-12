package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator;

import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;

public interface NewCompanyValidator {

    void check(NewCompanyDto companyDto);

}
