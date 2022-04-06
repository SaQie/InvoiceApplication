package pl.saqie.InvoiceApp.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import pl.saqie.InvoiceApp.app.components.client.entity.Client;
import pl.saqie.InvoiceApp.app.components.client.entity.Role;
import pl.saqie.InvoiceApp.app.components.client.usecase.ClientAuthUseCase;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.ClientExistsException;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.validator.exception.MissmatchPasswordException;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientAuthUseCaseTest {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final ClientAuthUseCase authUseCase;

    @Autowired
    ClientAuthUseCaseTest(DataSource dataSource, JdbcTemplate jdbcTemplate, ClientAuthUseCase authUseCase) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.authUseCase = authUseCase;
    }

    @BeforeEach
    void prepareDatabase() {
        clearDatabase();
    }

    private RegisterClientDto initializeRegisterClientDto(){
        return RegisterClientDto.builder()
                .username("username")
                .password("password")
                .passwordRepeat("password")
                .email("example@example.com").build();
    }

    private void clearDatabase() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator
                (false, false, "UTF-8", new ClassPathResource("clearDatabase.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

    @Test
    void shouldReturnNewClientInstance() {
        // given
        RegisterClientDto registerClientDto = initializeRegisterClientDto();
        // when
        Client client = authUseCase.registerClient(registerClientDto);
        // then
        assertAll(
                () -> assertNotNull(client),
                () -> assertInstanceOf(Client.class, client)
        );
    }

    @Test
    void shouldReturnClientWithTheSameGivenFields() {
        // given
        RegisterClientDto registerClientDto = initializeRegisterClientDto();
        // when
        Client client = authUseCase.registerClient(registerClientDto);
        // then
        assertAll(
                () -> assertNotNull(client),
                () -> assertEquals("username", client.getUsername()),
                () -> assertEquals("example@example.com", client.getEmail())
        );
    }

    @Test
    void shouldReturnClientWithDefaultRoleAfterRegister(){
        // given
        RegisterClientDto registerClientDto = initializeRegisterClientDto();
        // when
        Client client = authUseCase.registerClient(registerClientDto);
        // then
        assertEquals(Role.PENDING_CLIENT, client.getRole());
    }

    @Test
    void shouldThrowsMissmatchPasswordExceptionWhenPasswordDoNotMatch(){
        // given
        RegisterClientDto registerClientDto = initializeRegisterClientDto();
        registerClientDto.setPasswordRepeat("test");
        // when

        // then
        assertThrows(MissmatchPasswordException.class,
                () -> authUseCase.registerClient(registerClientDto));
    }

    @Test
    void shouldThrowsClientExistsExceptionWhenUsernameOrEmailAlreadyExists(){
        // given
        RegisterClientDto registerClientDto = initializeRegisterClientDto();
        RegisterClientDto registerClientDto2 = initializeRegisterClientDto();
        authUseCase.registerClient(registerClientDto2);
        // when

        // then
        assertThrows(ClientExistsException.class,
                () -> authUseCase.registerClient(registerClientDto));
    }

}