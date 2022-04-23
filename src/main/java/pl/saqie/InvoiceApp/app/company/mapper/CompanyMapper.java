package pl.saqie.InvoiceApp.app.company.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.company.Company;

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
