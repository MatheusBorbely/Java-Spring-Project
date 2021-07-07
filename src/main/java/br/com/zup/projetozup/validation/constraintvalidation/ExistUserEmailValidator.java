package br.com.zup.projetozup.validation.constraintvalidation;

import br.com.zup.projetozup.domain.repository.UsuarioRepository;
import br.com.zup.projetozup.validation.ExistUserEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistUserEmailValidator implements ConstraintValidator<ExistUserEmail, String> {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public void initialize(ExistUserEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return usuarioRepository.findByEmail(s)
                .isEmpty();
    }
}
