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
import br.wendel.petshop.dtos.FuncionarioRequestDTO;
import br.wendel.petshop.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioRequestDTO> listarFuncionarios(){
       return funcionarioService.listarTodosFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioRequestDTO buscarPorId(@PathVariable Long id){
       return funcionarioService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<FuncionarioRequestDTO> cadastrarFuncionario(@RequestBody @Valid FuncionarioRequestDTO funcionario){
        FuncionarioRequestDTO dto = funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable @Valid Long id){
        funcionarioService.deletarPorId(id);
    }

}
