package com.qintess.Carros.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.Carros.Model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	Optional<Carro> findByPlaca(String placa);
}
