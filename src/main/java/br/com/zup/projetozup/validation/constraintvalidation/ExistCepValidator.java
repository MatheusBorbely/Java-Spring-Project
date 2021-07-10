package br.com.zup.projetozup.validation.constraintvalidation;

import br.com.zup.projetozup.microservice.EnderecoDtoViaCep;
import br.com.zup.projetozup.microservice.ViaCEPCliente;
import br.com.zup.projetozup.validation.ExistCep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ExistCepValidator implements ConstraintValidator<ExistCep, String> {


    private final ViaCEPCliente viaCEPCliente;

    @Autowired
    public ExistCepValidator(ViaCEPCliente viaCEPCliente) {
        this.viaCEPCliente = viaCEPCliente;
    }


    @Override
    public void initialize(ExistCep constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        EnderecoDtoViaCep enderecoDtoViaCep = viaCEPCliente.buscaEnderecoPor(s);
        return enderecoDtoViaCep.getErro() == null;


    }
}
