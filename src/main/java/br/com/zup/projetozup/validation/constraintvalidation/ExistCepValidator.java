package br.com.zup.projetozup.validation.constraintvalidation;

import br.com.zup.projetozup.domain.repository.UsuarioRepository;
import br.com.zup.projetozup.microservice.EnderecoDtoViaCep;
import br.com.zup.projetozup.microservice.ViaCEPCliente;
import br.com.zup.projetozup.validation.ExistCep;
import br.com.zup.projetozup.validation.ExistUserEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ExistCepValidator implements ConstraintValidator<ExistCep, String> {

    @Autowired
    private ViaCEPCliente viaCEPCliente;


    @Override
    public void initialize(ExistCep constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.length() < 8  || s.length() > 9) return false;
        EnderecoDtoViaCep enderecoDtoViaCep = viaCEPCliente.buscaEnderecoPor(s);
        return enderecoDtoViaCep.getErro() != null;


    }
}
