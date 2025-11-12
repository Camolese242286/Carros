package com.qintess.Carros.Service;

import org.springframework.stereotype.Service;

import com.qintess.Carros.DTO.CarroDTO;
import com.qintess.Carros.Model.Carro;
import com.qintess.Carros.Model.Pessoa;
import com.qintess.Carros.Repository.CarroRepository;
import com.qintess.Carros.Repository.PessoaRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarroService {

    private  CarroRepository repository;

    private PessoaRepository pessoaRepository;

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

        // Buscar e associar a pessoa
        if (dto.getPessoa() != null && dto.getPessoa().getId() != null) {
            Pessoa pessoa = pessoaRepository.findById(dto.getPessoa().getId())
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
            carro.setPessoa(pessoa);
        }

        carro = repository.save(carro);

        return new CarroDTO(carro);
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
