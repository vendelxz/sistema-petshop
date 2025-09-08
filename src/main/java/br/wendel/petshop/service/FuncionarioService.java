package br.wendel.petshop.service;
import br.wendel.petshop.entity.Funcionario;
import br.wendel.petshop.dtos.*;
import br.wendel.petshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();
        funcionario.setId(funcionarioDTO.getId());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setCargo(funcionarioDTO.getCargo());
        Funcionario salvo = funcionarioRepository.save(funcionario);

        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(salvo.getId());
        dto.setNome(salvo.getNome());
        dto.setCargo(salvo.getCargo());
        return dto;
    }

    public FuncionarioDTO buscarPorId(Long Id){
        Funcionario funcionario = funcionarioRepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setCargo(funcionario.getCargo());
        return dto;
    }

    public List<FuncionarioDTO> listarTodosFuncionarios() {
    List<Funcionario> funcionarios = funcionarioRepository.findAll();
    if (funcionarios.isEmpty()) {
        throw new RuntimeException("Nenhum funcionário encontrado");
    }
    return funcionarios.stream().map(f -> {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(f.getId());
        dto.setNome(f.getNome());
        dto.setCargo(f.getCargo());
        return dto;
    }).toList();
}

    public void deletarPorId(Long id) {
    if (!funcionarioRepository.existsById(id)) {
        throw new RuntimeException("Funcionário não encontrado");
    }
    funcionarioRepository.deleteById(id);
}
}
