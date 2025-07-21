package com.qintess.Carros.Model;

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
}