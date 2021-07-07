package br.com.zup.projetozup.domain.repository;

import br.com.zup.projetozup.domain.entity.Endereco;
import br.com.zup.projetozup.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;



public interface EnderecoRepository extends JpaRepository <Endereco, UUID> {

    Optional<Endereco> findByCepAndNumeroAndUsuario_id(String cep, Integer numero, UUID id);

}
