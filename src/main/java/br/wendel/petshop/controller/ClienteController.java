package br.wendel.petshop.controller;

import br.wendel.petshop.dtos.ClienteRequestDTO;
import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.repository.ClienteRepository;
import br.wendel.petshop.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteRequestDTO> listarClientes() {
         return clienteRepository.findAll()
        .stream()
        .map(cliente -> {
            ClienteRequestDTO dto = new ClienteRequestDTO();
            dto.setNome(cliente.getNome());
            dto.setEmail(cliente.getEmail());
            dto.setTelefone(cliente.getTelefone());
            return dto;
        })
        .toList();
}

    @GetMapping("/{id}")
    public ClienteRequestDTO buscarPorid(@PathVariable Long id) {
        return clienteService.buscarPorid(id);
    }

    @PostMapping
    public ResponseEntity<ClienteRequestDTO> cadastrarCliente(@RequestBody @Valid ClienteRequestDTO clienteDTO) {
        ClienteRequestDTO dto = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
}
    

    @DeleteMapping("/{cpf}")
    public void deletarPeloid(@PathVariable @Valid Long id) {
        clienteService.deletarPorId(id);
    }

} 
