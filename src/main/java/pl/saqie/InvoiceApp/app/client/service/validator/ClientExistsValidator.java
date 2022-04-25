package pl.saqie.InvoiceApp.app.client.service.validator;

import lombok.AllArgsConstructor;
import pl.saqie.InvoiceApp.app.client.dto.RegisterClientDto;
import pl.saqie.InvoiceApp.app.client.repository.ClientRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class ClientExistsValidator implements ConstraintValidator<ClientExists, RegisterClientDto> {

    private final ClientRepository clientRepository;

    @Override
    public boolean isValid(RegisterClientDto registerClientDto, ConstraintValidatorContext constraintValidatorContext) {
        return !clientRepository.existsByEmail(registerClientDto.getEmail()) && !clientRepository.existsByUsername(registerClientDto.getUsername());
    }
}
