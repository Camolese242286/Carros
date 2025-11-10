package com.qintess.Carros.DTO;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.qintess.Carros.Model.Pessoa;

import lombok.Data;

@Data
public class PessoaDto {

	private Long id;
	private String nome;
	private List<CarroDTO> carros;
	
	
	public PessoaDto() {}
	
	public PessoaDto(Pessoa pessoa) {
		
		this.id=pessoa.getId();
		this.nome=pessoa.getNome();
		
		if(pessoa.getCarro() != null ) {
			this.carros=pessoa.getCarro().stream().map(CarroDTO::new).collect(Collectors.toList());
		}
	}
	
}
