package br.wendel.petshop.mappers.funcionario;

import org.springframework.stereotype.Component;

import br.wendel.petshop.dtos.funcionarios.FuncionarioDTO;
import br.wendel.petshop.dtos.funcionarios.FuncionarioResponseDTO;
import br.wendel.petshop.entity.Funcionario;
import jakarta.persistence.EntityNotFoundException;


@Component
public class FuncionarioMapper {

    public FuncionarioDTO toDTO(Funcionario funcionario){
        if(funcionario == null){
            throw new EntityNotFoundException("Funcionário não existe no sistema!");
        }
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setCpf(funcionario.getCpf());
        dto.setCargo(funcionario.getCargo());
        dto.setEmail(funcionario.getEmail());

        return dto;
    }

    public FuncionarioResponseDTO toResponseDTO(Funcionario funcionario){
        if(funcionario == null){
            throw new EntityNotFoundException("Funcionário não existe no sistema!");
        }

        FuncionarioResponseDTO dto = new FuncionarioResponseDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setEmail(funcionario.getEmail());
        dto.setCargo(funcionario.getCargo());
        
        return dto;
    }


}
