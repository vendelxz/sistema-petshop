package br.wendel.petshop.controller;

import br.wendel.petshop.dtos.cliente.ClienteDTO;
import br.wendel.petshop.dtos.cliente.ClienteResponseDTO;
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
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        List<ClienteResponseDTO> clientes = clienteService.acharTodos();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
}

    @GetMapping("/{id}")
    public ClienteResponseDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteResponseDTO dto = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
}
    

    @DeleteMapping("/{id}")
    public void deletarPeloid(@PathVariable @Valid Long id) {
        clienteService.deletarPorId(id);
    }

} 
