package br.com.zup.projetozup.validation;

import br.com.zup.projetozup.validation.constraintvalidation.ExistCepValidator;
import br.com.zup.projetozup.validation.constraintvalidation.ExistUserAddressValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistCepValidator.class)
public @interface ExistCep {

    String message() default "Cep não existente";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
