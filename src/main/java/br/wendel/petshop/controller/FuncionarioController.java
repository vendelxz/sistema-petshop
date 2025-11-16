package br.wendel.petshop.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.wendel.petshop.dtos.funcionarios.FuncionarioDTO;
import br.wendel.petshop.dtos.funcionarios.FuncionarioResponseDTO;
import br.wendel.petshop.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> acharTodos(){
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.acharTodos();
        return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> acharPorId(@PathVariable @Valid Long id){
        FuncionarioResponseDTO funcionario = funcionarioService.buscarPeloId(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> cadastrarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
        FuncionarioResponseDTO funcionarioCadastrado = funcionarioService.cadastrarFuncionario(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCadastrado);
    }

    @DeleteMapping("/{id}")
    public void deletarPeloid(@Valid @PathVariable Long id){
        funcionarioService.deletarPorId(id);
        ResponseEntity.status(HttpStatus.OK).body("Funcionário deletado com sucesso!");
    }
    

}
