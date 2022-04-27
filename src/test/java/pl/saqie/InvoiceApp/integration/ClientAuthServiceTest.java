package pl.saqie.InvoiceApp.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.client.Role;
import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.client.service.ClientAuthService;
import pl.saqie.InvoiceApp.app.client.exception.ClientExistsException;
import pl.saqie.InvoiceApp.app.client.exception.MissmatchPasswordException;

import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientAuthServiceTest {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final MockMvc mockMvc;
    private final ClientAuthService clientAuthService;
    private final Validator validator;


    @Autowired
    public ClientAuthServiceTest(DataSource dataSource, JdbcTemplate jdbcTemplate, MockMvc mockMvc, ClientAuthService clientAuthService, Validator validator) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.mockMvc = mockMvc;
        this.clientAuthService = clientAuthService;
        this.validator = validator;
    }


    @BeforeEach
    void prepareDatabase() {
        clearDatabase();
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator
                (false, false, "UTF-8", new ClassPathResource("data.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

    private void clearDatabase() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator
                (false, false, "UTF-8", new ClassPathResource("clearDatabase.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

    private RegisterClientDto createRequest(){
        return RegisterClientDto.builder()
                .username("username")
                .email("test@test.pl")
                .password("password")
                .passwordRepeat("password")
                .build();
    }


    @Test
    void shouldReturnNewClientInstance() {
        // given
        RegisterClientDto request = createRequest();
        // when
        Client client = clientAuthService.registerNewClient(request);
        // then
        assertAll(
                () -> assertNotNull(client),
                () -> assertInstanceOf(Client.class, client)
        );
    }

    @Test
    void shouldReturnClientWithTheSameGivenFields() {
        // given
        RegisterClientDto registerClientDto = createRequest();
        // when
        Client client = clientAuthService.registerNewClient(registerClientDto);
        // then
        assertAll(
                () -> assertNotNull(client),
                () -> assertEquals("username", client.getUsername()),
                () -> assertEquals("test@test.pl", client.getEmail())
        );
    }

    @Test
    void shouldReturnClientWithDefaultRoleAfterRegister(){
        // given
        RegisterClientDto request = createRequest();
        // when
        Client client = clientAuthService.registerNewClient(request);
        // then
        assertEquals(Role.PENDING_CLIENT, client.getRole());
    }

    @Test
    void shouldValidatePasswordRepeatCorrect(){
        // given
        RegisterClientDto request = createRequest();
        request.setPasswordRepeat("test");
        // when
        Set<ConstraintViolation<RegisterClientDto>> violations = validator.validate(request);
        // then
        assertEquals(1, violations.size());
    }

    @Test
    void shouldValidateClientAlreadyExists(){
        // given
        RegisterClientDto request = createRequest();
        RegisterClientDto request1 = createRequest();
        clientAuthService.registerNewClient(request1);
        // when
        Set<ConstraintViolation<RegisterClientDto>> violations = validator.validate(request);
        // then
        assertEquals(1,violations.size());
    }


    @Test
    @WithUserDetails(value = "Kamil")
    void shouldReturnStatusOf200ForTheLoggedInClient() throws Exception {
        // given

        // when

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/add/company"))
                .andExpect(status().isOk());

    }

    @Test
    @WithAnonymousUser
    void shouldReturnStatusOf400ForTheAnonymousClient() throws Exception {
        // given

        // when

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/add/company"))
                .andExpect(status().isUnauthorized());
    }

}
