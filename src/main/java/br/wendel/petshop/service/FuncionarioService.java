package br.wendel.petshop.service;

import br.wendel.petshop.entity.Funcionario;
import br.wendel.petshop.exception.CpfExistsException;
import br.wendel.petshop.mappers.funcionario.FuncionarioMapper;
import br.wendel.petshop.dtos.funcionarios.FuncionarioDTO;
import br.wendel.petshop.dtos.funcionarios.FuncionarioResponseDTO;
import br.wendel.petshop.repository.*;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    FuncionarioMapper funcionarioMapper;

    //Método para cadastrar funcionário utilizando o mapper!!!
    public FuncionarioResponseDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO){
        if(funcionarioRepository.existsByCpf(funcionarioDTO.getCpf())){
            throw new CpfExistsException("O CPF já existe no banco de dados, procure o administrador!");
        }
        Funcionario funcionario = new Funcionario();
        funcionario.setId(funcionarioDTO.getId());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setCargo(funcionarioDTO.getCargo());

        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);

        return funcionarioMapper.toResponseDTO(savedFuncionario);

    }

    public void deletarPorId(Long id){
        if(funcionarioRepository.existsById(id)){
            funcionarioRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("O funcionário não foi encontrado com o id: "+ id);
    }
        }
        

    public FuncionarioResponseDTO buscarPeloId(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("O funcionário não foi encontrado com o id: "+ id));

            return funcionarioMapper.toResponseDTO(funcionario);
    }

    public List<FuncionarioResponseDTO> acharTodos(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        return funcionarios.stream()
        .map(funcionario -> funcionarioMapper.toResponseDTO(funcionario))
        .toList();
    }







   

}

   
