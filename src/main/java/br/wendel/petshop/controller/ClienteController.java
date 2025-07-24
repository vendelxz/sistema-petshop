package br.wendel.petshop.controller;

import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{cpf}")
    public Optional<Cliente> buscarPorCpf(@PathVariable String cpf) {
        return clienteRepository.findById(cpf);
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{cpf}")
    public void deletarCliente(@PathVariable @Valid String cpf) {
        clienteRepository.deleteById(cpf);
    }

} 
