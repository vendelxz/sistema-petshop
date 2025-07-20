package br.wendel.petshop.controller;

import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // GET /clientes → lista todos os clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // GET /clientes/{cpf} → busca cliente por CPF
    @GetMapping("/{cpf}")
    public Optional<Cliente> buscarPorCpf(@PathVariable String cpf) {
        return clienteRepository.findById(cpf);
    }

    // POST /clientes → cadastra novo cliente
    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // DELETE /clientes/{cpf} → remove cliente
    @DeleteMapping("/{cpf}")
    public void deletarCliente(@PathVariable String cpf) {
        client
