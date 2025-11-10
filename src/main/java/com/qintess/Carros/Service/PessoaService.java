package com.qintess.Carros.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.Carros.DTO.PessoaDto;
import com.qintess.Carros.Model.Pessoa;
import com.qintess.Carros.Repository.PessoaRepository;



@Service


public class PessoaService {
    @Autowired
	private PessoaRepository repository;
    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }
	
	public List<PessoaDto> listar(){
		return repository.findAll().stream().map(PessoaDto::new).collect(Collectors.toList());
	}
	
	public PessoaDto salvar(Pessoa pessoa) {
		
		return new PessoaDto(repository.save(pessoa));
	}
}
