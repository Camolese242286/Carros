package com.qintess.Carros.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.Carros.DTO.PessoaDto;
import com.qintess.Carros.Model.Pessoa;
import com.qintess.Carros.Service.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {

	private PessoaService service;
	
	
	@GetMapping
	public List<PessoaDto> listar(){
		
		return service.listar();
	}
	
	@PostMapping
	public PessoaDto criar(@RequestBody Pessoa pessoa) {
		
		return service.salvar(pessoa);
	}
	
}
