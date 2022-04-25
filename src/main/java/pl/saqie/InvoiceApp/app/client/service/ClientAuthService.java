package pl.saqie.InvoiceApp.app.client.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.saqie.InvoiceApp.app.client.repository.ClientRepository;
import pl.saqie.InvoiceApp.app.client.Client;
import pl.saqie.InvoiceApp.app.client.Role;
import pl.saqie.InvoiceApp.app.client.mapper.ClientMapper;
import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ClientAuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientAuthService.class);
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    public Client registerNewClient(RegisterClientDto clientDto){
        LOGGER.info("Add new user to database ( " + clientDto + " )");
        var client = clientMapper.mapDtoToEntity(clientDto);
        return clientRepository.save(client);
    }

    public void reloadClientRole(){
        Authentication oldAuthentication = SecurityContextHolder.getContext().getAuthentication();
        Set<GrantedAuthority> newRoles = new HashSet<>(oldAuthentication.getAuthorities());
        newRoles.add(new SimpleGrantedAuthority(Role.CLIENT.toString()));
        Authentication newAuth = new UsernamePasswordAuthenticationToken(oldAuthentication.getPrincipal(),
                oldAuthentication.getCredentials(), newRoles);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }



}
