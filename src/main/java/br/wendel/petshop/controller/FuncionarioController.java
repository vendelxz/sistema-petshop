package br.wendel.petshop.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.wendel.petshop.entity.Funcionario;
import br.wendel.petshop.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{cpf}")
    public Optional<Funcionario> buscarPorId(@PathVariable String id){
        return funcionarioRepository.findById(id);
    }

    @PostMapping
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable String id){
        funcionarioRepository.deleteById(id);
    }

}
