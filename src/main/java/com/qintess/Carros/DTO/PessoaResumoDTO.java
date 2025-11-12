package com.qintess.Carros.DTO;

import com.qintess.Carros.Model.Pessoa;
import lombok.Data;

@Data
public class PessoaResumoDTO {
    private Long id;
    private String nome;

    
    public PessoaResumoDTO() {
        // construtor vazio necessário para o Jackson
    }
    
    public PessoaResumoDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
    }
    



}
