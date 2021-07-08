package br.com.zup.projetozup.validation;

import br.com.zup.projetozup.validation.constraintvalidation.ExistUserAddressValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ExistUserAddressValidator.class)
public @interface ExistUserAddress {

    String message() default "Usuário já possui esse endereço cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
