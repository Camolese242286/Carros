package com.qintess.Carros.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.qintess.Carros.DTO.CarroDTO;
import com.qintess.Carros.Model.Carro;
import com.qintess.Carros.Model.Pessoa;
import com.qintess.Carros.Service.CarroService;
import com.qintess.Carros.Service.PessoaService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carros")
public class CarroController {
	@Autowired
	private PessoaService pessoaSer;

    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<CarroDTO> buscarPorPlaca(@PathVariable String placa) {
        Carro carro = service.findByPlaca(placa)
                     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(new CarroDTO(carro));
    }
    
    @GetMapping
    public List<CarroDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CarroDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CarroDTO cadastrar(@RequestBody CarroDTO dto) {
        
    	if (dto.getPessoa() != null && dto.getPessoa().getId() != null) {
            Pessoa pessoa = pessoaSer.findById(dto.getPessoa().getId())
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
            dto.setPessoa(pessoa);
        }
    	
    	return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public CarroDTO atualizar(@PathVariable Long id, @RequestBody CarroDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
