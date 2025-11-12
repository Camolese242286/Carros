package com.qintess.Carros.DTO;

import com.qintess.Carros.Model.Carro;
import com.qintess.Carros.Model.Pessoa;

import lombok.Data;


@Data
public class CarroDTO {

    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private PessoaResumoDTO pessoa;
  
    public CarroDTO() {}

   
    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.ano = carro.getAno();
        if (carro.getPessoa() != null)
            this.pessoa = new PessoaResumoDTO(carro.getPessoa());
    }
     
    }
