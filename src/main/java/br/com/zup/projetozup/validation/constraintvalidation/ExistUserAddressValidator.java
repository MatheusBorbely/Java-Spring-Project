package br.com.zup.projetozup.validation.constraintvalidation;

import br.com.zup.projetozup.domain.repository.EnderecoRepository;
import br.com.zup.projetozup.rest.dto.request.RequestEndereco;
import br.com.zup.projetozup.validation.ExistUserAddress;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistUserAddressValidator implements ConstraintValidator<ExistUserAddress, RequestEndereco> {


    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ExistUserAddressValidator(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void initialize(ExistUserAddress constraintAnnotation) {

    }

    @Override
    public boolean isValid(RequestEndereco requestEndereco, ConstraintValidatorContext constraintValidatorContext) {
        return enderecoRepository.findByCepAndNumeroAndUsuario_id(requestEndereco.getCep().replaceAll("\\p{Punct}", ""),
                requestEndereco.getNumero(), requestEndereco.getUsuarioId()).isEmpty();
    }
}

