package com.qintess.Carros.Service;

import org.springframework.stereotype.Service;

import com.qintess.Carros.DTO.CarroDTO;
import com.qintess.Carros.Model.Carro;
import com.qintess.Carros.Repository.CarroRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public List<CarroDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarroDTO::new)
                .collect(Collectors.toList());
    }

    public CarroDTO buscarPorId(Long id) {
        Carro carro = repository.findById(id).orElseThrow();
        return new CarroDTO(carro);
    }

    public CarroDTO salvar(CarroDTO dto) {
        Carro carro = new Carro();
       
        carro.setPlaca(dto.getPlaca());
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setAno(dto.getAno());
        carro.setPessoa(dto.getPessoa());
        return new CarroDTO(repository.save(carro));
    }

    public CarroDTO atualizar(Long id, CarroDTO dto) {
        Carro carro = repository.findById(id).orElseThrow();
        
        carro.setPlaca(dto.getPlaca());
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setAno(dto.getAno());
        return new CarroDTO(repository.save(carro));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<Carro> findByPlaca(String placa) {
        return repository.findByPlaca(placa); // Supondo que isso retorne um Optional
    }

}
