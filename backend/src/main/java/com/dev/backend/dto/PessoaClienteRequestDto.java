package com.dev.backend.dto;

import org.springframework.beans.BeanUtils;

import com.dev.backend.entity.Cidade;
import com.dev.backend.entity.Pessoa;

import lombok.Data;

@Data
public class PessoaClienteRequestDto {
    
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;

    private Cidade cidade;

    //Vao copiar os atributos da classe dto para pessoa 
    public Pessoa converter(PessoaClienteRequestDto pessoaClienteRequestDto) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDto, pessoa);
        return pessoa;
    }
}
