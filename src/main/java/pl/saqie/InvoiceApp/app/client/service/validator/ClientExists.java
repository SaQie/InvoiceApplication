package pl.saqie.InvoiceApp.app.client.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClientExistsValidator.class)
public @interface ClientExists {

    String message() default "User already exists !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
