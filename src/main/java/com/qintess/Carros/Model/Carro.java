package com.qintess.Carros.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    
    @ManyToOne
    @JoinColumn(name="pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;
}