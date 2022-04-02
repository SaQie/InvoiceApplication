package pl.saqie.InvoiceApp.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import pl.saqie.InvoiceApp.app.components.client.Client;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.ClientRegisterUseCase;
import pl.saqie.InvoiceApp.app.components.client.usecase.register.dto.RegisterClientDto;


import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientRegisterUseCaseTest {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final ClientRegisterUseCase userService;

    @Autowired
    ClientRegisterUseCaseTest(DataSource dataSource, JdbcTemplate jdbcTemplate, ClientRegisterUseCase userService) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.userService = userService;
    }

    @BeforeEach
    void prepareDatabase(){
        clearDatabase();

    }

    void clearDatabase(){
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator
                (false,false,"UTF-8", new ClassPathResource("clearDatabase.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

    @Test
    void shouldReturnNewClientInstance(){
        // given
        RegisterClientDto registerClientDto = RegisterClientDto.builder()
                .username("username")
                .password("password")
                .passwordRepeat("password")
                .email("example@example.com").build();
        // when
        Client client = userService.registerNewClient(registerClientDto);
        // then
        assertAll(
                () -> assertNotNull(client),
                () -> assertInstanceOf(Client.class, client)
        );
    }

    @Test
    void shouldReturnClientWithTheSameGivenFields(){
        // given
        RegisterClientDto registerClientDto = RegisterClientDto.builder()
                .username("name")
                .password("password")
                .passwordRepeat("password")
                .email("example@example.com").build();
        // when
        Client client = userService.registerNewClient(registerClientDto);
        // then
        assertAll(
                () -> assertNotNull(client),
                () -> assertEquals("name", client.getUsername()),
                () -> assertEquals("example@example.com", client.getEmail())
        );
    }

}