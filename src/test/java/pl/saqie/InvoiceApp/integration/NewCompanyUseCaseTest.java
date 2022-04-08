package pl.saqie.InvoiceApp.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import pl.saqie.InvoiceApp.app.components.client.ClientRepository;
import pl.saqie.InvoiceApp.app.components.client.ClientService;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.company.CompanyService;
import pl.saqie.InvoiceApp.app.components.company.entity.Company;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.components.company.usecase.newcompany.validator.exception.PhoneNumberValidationException;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewCompanyUseCaseTest {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyService companyService;
    private final ClientRepository clientRepository;

    @Autowired
    public NewCompanyUseCaseTest(DataSource dataSource, JdbcTemplate jdbcTemplate, CompanyService companyService, ClientRepository clientRepository) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.companyService = companyService;
        this.clientRepository = clientRepository;
    }

    @BeforeEach
    void prepareDatabase() {
        clearDatabase();
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false,false,
                "UTF-8", new ClassPathResource("data.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

    private void clearDatabase() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator
                (false, false, "UTF-8", new ClassPathResource("clearDatabase.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

    private NewCompanyDto initializeNewCompanyDto(){
        return NewCompanyDto.builder()
                .name("Kaczka S.A")
                .adress("Kozarow 3/2")
                .ownerName("Kamil")
                .ownerLastName("Nowak")
                .telephoneNumber("123321123")
                .nip("5337768715")
                .regon("791795202").build();
    }

    @Test
    void shouldReturnNewCompanyInstance(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        Client client = clientRepository.findById(1L).orElse(null);
        // when
        Company newCompany = companyService.createNewCompany(newCompanyDto,client);
        // then
        assertAll(
                () -> assertNotNull(newCompany),
                () -> assertInstanceOf(Company.class, newCompany)
        );
    }

    @Test
    void shouldReturnNewCompanyWithGivenFields(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        Client client = clientRepository.findById(1L).orElse(null);
        // when
        Company newCompany = companyService.createNewCompany(newCompanyDto, client);
        // then
        assertAll(
                () -> assertNotNull(client),
                () -> assertEquals("Kaczka S.A", newCompany.getName()),
                () -> assertEquals("Kozarow 3/2", newCompany.getAdress()),
                () -> assertEquals("Kamil", newCompany.getOwnerName()),
                () -> assertEquals("Nowak", newCompany.getOwnerLastName()),
                () -> assertEquals(1L, newCompany.getClient().getId()),
                () -> assertEquals("791795202", newCompany.getRegon()),
                () -> assertEquals("5337768715", newCompany.getNip())
        );
    }

    @Test
    void shouldIncreaseClientNumberOfCompaniesAfterAddNewCompany(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        Client client = clientRepository.findById(1L).orElse(null);
        // when
        Company newCompany = companyService.createNewCompany(newCompanyDto, client);
        // then
        assertNotNull(client);
        assertEquals(1,client.getNumberOfCompanies());
    }

    @Test
    void shouldThrowsPhoneNumberValidationExceptionWhenTelephoneNumberIsIncorrect(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        Client client = clientRepository.findById(1L).orElse(null);
        newCompanyDto.setTelephoneNumber("123123");
        // when

        // then
        assertThrows(PhoneNumberValidationException.class, () -> companyService.createNewCompany(newCompanyDto,client));
    }


}