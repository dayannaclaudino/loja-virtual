package com.dev.backend.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dto.PessoaClienteRequestDto;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaClienteRepository;

@Service
public class PessoaClienteService {
    
    @Autowired
    private PessoaClienteRepository pessoaClienteRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    public Pessoa registrar(PessoaClienteRequestDto pessoaClienteRequestDto){
        Pessoa pessoa = new PessoaClienteRequestDto().converter(pessoaClienteRequestDto);
        pessoa.setDataCriacao(new Date());
        Pessoa objetoNovo = pessoaClienteRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCLiente(objetoNovo);
        //emailService.enviarEmailTexto(objetoNovo.getEmail(), "Cadastro na Loja Virtual ", 
       // "O registro na loja foi realizado com sucesso. Em breve você receberá a senha de acesso por email.");
       Map<String, Object> proprMap = new HashMap<>();
       proprMap.put("nome", objetoNovo.getNome());
       proprMap.put("mensagem", "O registro na loja foi realizado com sucesso. Em breve você receberá a senha de acesso por email."); 
        emailService.enviarEmailTemplate(objetoNovo.getEmail(), "Cadastro na Loja Virtual", proprMap);
        return objetoNovo;
    }

    
}
