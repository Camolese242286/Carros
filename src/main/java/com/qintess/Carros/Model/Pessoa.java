package com.qintess.Carros.Model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Pessoa {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	private String nome;

	@OneToMany(mappedBy="pessoa",orphanRemoval = true)
	private List<Carro>carro;
	
	public Pessoa(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Pessoa() {
		super();
	}
	
	
	
}
