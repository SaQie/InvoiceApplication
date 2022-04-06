package pl.saqie.InvoiceApp.app.components.company.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.components.company.entity.Company;

@Service
@AllArgsConstructor
public class CompanyMapper {

    public Company mapFromNewCompanyDtoToEntity(NewCompanyDto newCompanyDto) {
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
