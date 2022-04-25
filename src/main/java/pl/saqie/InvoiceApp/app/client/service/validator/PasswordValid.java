package pl.saqie.InvoiceApp.app.client.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface PasswordValid {

    String message() default "Passwords not match ! ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
