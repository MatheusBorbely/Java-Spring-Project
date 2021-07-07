package br.com.zup.projetozup.validation;

import br.com.zup.projetozup.validation.constraintvalidation.ExistUserEmailValidator;
import br.com.zup.projetozup.validation.constraintvalidation.ExistUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistUserValidator.class)
public @interface ExistUser {

    String message() default "Usuário não existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}