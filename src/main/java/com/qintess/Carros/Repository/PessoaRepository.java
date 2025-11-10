package com.qintess.Carros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.Carros.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
