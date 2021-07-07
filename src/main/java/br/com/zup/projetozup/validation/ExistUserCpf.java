package br.com.zup.projetozup.validation;


import br.com.zup.projetozup.validation.constraintvalidation.ExistUserCpfValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistUserCpfValidator.class)
public @interface ExistUserCpf {

    String message() default "Usuário já existente";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
