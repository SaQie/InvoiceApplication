package pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.mapper;

import pl.saqie.InvoiceApp.app.components.company.Company;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.NewCompanyDto;

public class CompanyMapper {

    public static Company mapFromNewCompanyDtoToEntity(NewCompanyDto newCompanyDto){
        return Company.builder()
                .name(newCompanyDto.getName())
                .adress(newCompanyDto.getAdress())
                .phoneNumber(newCompanyDto.getTelephoneNumber())
                .regon(newCompanyDto.getRegon())
                .nip(newCompanyDto.getNip())
                .ownerLastName(newCompanyDto.getOwnerLastName())
                .ownerName(newCompanyDto.getOwnerName())
                .build();
    }

}
