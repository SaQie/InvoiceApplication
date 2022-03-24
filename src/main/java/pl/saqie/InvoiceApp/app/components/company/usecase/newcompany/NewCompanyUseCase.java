package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany;

import pl.saqie.InvoiceApp.app.components.client.Client;

public interface NewCompanyUseCase {

    void addNewCompanyToClient(NewCompanyDto newCompanyDto, Client client);

}
