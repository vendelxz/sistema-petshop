package br.wendel.petshop.service;

import br.wendel.petshop.dtos.cliente.ClienteDTO;
import br.wendel.petshop.dtos.cliente.ClienteResponseDTO;
import br.wendel.petshop.dtos.funcionarios.FuncionarioResponseDTO;
import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.exception.CpfExistsException;
import br.wendel.petshop.mappers.cliente.ClienteMapper;
import br.wendel.petshop.repository.*;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service 
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository; 

    @Autowired
    ClienteMapper clienteMapper;

    
    public ClienteResponseDTO cadastrarCliente(ClienteDTO clienteDTO) {
      //Todo: Usar o método do mapper para criar o cadastro 
      if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {  
        throw new CpfExistsException("Este CPF já existe no banco de dados, procure o admnistrador!");     
        }

        Cliente newCliente = new Cliente();
        newCliente.setId(clienteDTO.getId());
        newCliente.setNome(clienteDTO.getNome());
        newCliente.setEmail(clienteDTO.getEmail());
        newCliente.setCpf(clienteDTO.getCpf());
        newCliente.setPets(clienteDTO.getPets());
        newCliente.setTelefone(clienteDTO.getTelefone());

        Cliente savedCliente = clienteRepository.save(newCliente);

        return clienteMapper.toResponseDTO(savedCliente);
    }


    @SuppressWarnings("null")
    public void deletarPorId(Long id) {
      if(clienteRepository.existsById(id)){
        clienteRepository.deleteById(id);
   }  else{
        throw new EntityNotFoundException("Cliente não encontrado com o id: "+ id);
   }
}


    @SuppressWarnings("null")
    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id)); 

        return clienteMapper.toResponseDTO(cliente); 
    }

    public List<ClienteResponseDTO> acharTodos(){
    
       List<Cliente> clientes = clienteRepository.findAll();

       return clientes.stream()
            .map(cliente -> clienteMapper.toResponseDTO(cliente)) 
            .toList();
        
    }

    


}


