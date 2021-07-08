package br.com.zup.projetozup.validation.constraintvalidation;

import br.com.zup.projetozup.domain.repository.UsuarioRepository;
import br.com.zup.projetozup.validation.ExistUserCpf;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistUserCpfValidator implements ConstraintValidator <ExistUserCpf, String>{


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ExistUserCpfValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public void initialize(ExistUserCpf constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return usuarioRepository.findByCpf(s.replaceAll("\\p{Punct}", ""))
                .isEmpty();
    }
}
