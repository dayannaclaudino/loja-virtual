package com.dev.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM Pessoa p WHERE p.nome LIKE CONCAT('%',:nome,'%')")
    List<Pessoa> findByNomeLike(@Param("nome") String nome);

    Pessoa findByEmail(String email);

    Pessoa findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha);
}
