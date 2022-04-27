package pl.saqie.InvoiceApp.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.test.context.support.WithUserDetails;
import pl.saqie.InvoiceApp.app.client.service.ClientAuthService;
import pl.saqie.InvoiceApp.app.client.repository.ClientRepository;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.company.service.CompanyService;
import pl.saqie.InvoiceApp.app.company.Company;
import pl.saqie.InvoiceApp.app.company.dto.NewCompanyDto;
import pl.saqie.InvoiceApp.app.company.exception.CompanyValidationException;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewCompanyUseCaseTest {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyService companyService;
    private final ClientRepository clientRepository;
    private final ClientAuthService clientService;
    private final Validator validator;

    @Autowired
    public NewCompanyUseCaseTest(DataSource dataSource, JdbcTemplate jdbcTemplate, CompanyService companyService, ClientRepository clientRepository, ClientAuthService clientService, Validator validator) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.companyService = companyService;
        this.clientRepository = clientRepository;
        this.clientService = clientService;
        this.validator = validator;
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
    @Transactional
    void shouldReturnNewCompanyInstance(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        Client client = clientRepository.getById(1L);
        // when
        Company newCompany = companyService.createNewCompany(newCompanyDto,client.getId());
        // then
        assertAll(
                () -> assertNotNull(newCompany),
                () -> assertInstanceOf(Company.class, newCompany)
        );
    }

    @Test
    @Transactional
    void shouldReturnNewCompanyWithGivenFields(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        Client client = clientRepository.getById(1L);
        // when
        Company newCompany = companyService.createNewCompany(newCompanyDto, client.getId());
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
    @Transactional
    void shouldIncreaseClientNumberOfCompaniesAfterAddNewCompany(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        Client client = clientRepository.getById(1L);
        // when
        companyService.createNewCompany(newCompanyDto, client.getId());
        // then
        assertNotNull(client);
        assertEquals(2,client.getNumberOfCompanies());
    }

    @Test
    void shouldValidateCompanyAlreadyExistsWithGivenName(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        newCompanyDto.setName("Oponeo S.A");
        // when
        Set<ConstraintViolation<NewCompanyDto>> violations = validator.validate(newCompanyDto);
        // then
        assertEquals(1,violations.size());
    }

    @Test
    void shouldValidateCompanyAlreadyExistsWithGivenNipNumber(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        newCompanyDto.setNip("3411390381");
        // when
        Set<ConstraintViolation<NewCompanyDto>> violations = validator.validate(newCompanyDto);
        // then
        assertEquals(1,violations.size());
    }

    @Test
    void shouldValidateCompanyAlreadyExistsWithGivenRegonNumber(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        newCompanyDto.setRegon("015730899");
        // when
        Set<ConstraintViolation<NewCompanyDto>> violations = validator.validate(newCompanyDto);
        // then
        assertEquals(1,violations.size());
    }

    @Test
    void shouldValidateCompanyAlreadyExistsWithGivenCompanyAdress(){
        // given
        NewCompanyDto newCompanyDto = initializeNewCompanyDto();
        newCompanyDto.setAdress("Komornika 2/2");
        // when
        Set<ConstraintViolation<NewCompanyDto>> violations = validator.validate(newCompanyDto);
        // then
        assertEquals(1,violations.size());
    }




}