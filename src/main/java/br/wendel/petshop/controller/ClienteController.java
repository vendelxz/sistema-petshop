package br.wendel.petshop.controller;

import br.wendel.petshop.dtos.ClienteDTO;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listarClientes() {
         return clienteRepository.findAll()
        .stream()
        .map(cliente -> {
            ClienteDTO dto = new ClienteDTO();
            dto.setNome(cliente.getNome());
            dto.setEmail(cliente.getEmail());
            dto.setTelefone(cliente.getTelefone());
            return dto;
        })
        .toList();
}

    @GetMapping("/{cpf}")
    public ClienteDTO buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarPorCpf(cpf);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO dto = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
}
    

    @DeleteMapping("/{cpf}")
    public void deletarCliente(@PathVariable @Valid String cpf) {
        clienteService.deletarPorId(cpf);
    }

} 
