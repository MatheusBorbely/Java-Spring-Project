package br.com.zup.projetozup.domain.repository;

import br.com.zup.projetozup.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmail(String email);

    @Query(" select u from Usuario u left join fetch u.enderecos where u.id =:id ")
    Optional<Usuario> findUsuarioFetchEndereco(@Param("id") UUID id);

}
