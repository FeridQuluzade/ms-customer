package az.bank.mscustomer.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy =ContactsValidator.class )
@Target( {ElementType.METHOD , ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactsConstraint {
    String message() default "Invalid contacts info";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
