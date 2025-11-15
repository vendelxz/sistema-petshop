package br.wendel.petshop.mappers.cliente;

import org.springframework.stereotype.Component;

import br.wendel.petshop.dtos.cliente.ClienteDTO;
import br.wendel.petshop.dtos.cliente.ClienteResponseDTO;
import br.wendel.petshop.entity.Cliente;
import jakarta.persistence.EntityNotFoundException;

@Component
public class ClienteMapper {

    public ClienteDTO toDto(Cliente cliente) throws EntityNotFoundException{
        
        if (cliente == null){
            return null;
            //Depois alterar para lançar uma exception...
        }
        ClienteDTO dto  = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        dto.setPets(cliente.getPets());

        return dto;

    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente) throws EntityNotFoundException{
        if (cliente == null){
            return null;
            //Lançar exception depois...
        }

        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome((cliente.getNome()));
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());

        return dto;
    }   

}
