package br.com.zup.projetozup.validation.constraintvalidation;

import br.com.zup.projetozup.domain.repository.UsuarioRepository;
import br.com.zup.projetozup.validation.ExistUser;
import br.com.zup.projetozup.validation.ExistUserEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class ExistUserValidator implements ConstraintValidator<ExistUser, UUID> {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public void initialize(ExistUser constraintAnnotation) {

    }

    @Override
    public boolean isValid(UUID id, ConstraintValidatorContext constraintValidatorContext) {
        return usuarioRepository.findById(id)
                .isPresent();
    }
}