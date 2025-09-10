package br.wendel.petshop.service;
import br.wendel.petshop.dtos.ClienteRequestDTO;
import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.exception.CpfExistsException;
import br.wendel.petshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service 
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository; 

    public ClienteRequestDTO cadastrarCliente(ClienteRequestDTO clienteDTO){
    Cliente cliente = new Cliente();
    if(clienteRepository.existsByCpf(clienteDTO.getCpf())){
       throw new CpfExistsException("CPF já cadastrado");
    }  
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        Cliente salvo = clienteRepository.save(cliente);

        ClienteRequestDTO dtoRetorno = new ClienteRequestDTO();
        dtoRetorno.setId(salvo.getId());
        dtoRetorno.setNome(salvo.getNome());
        dtoRetorno.setEmail(salvo.getEmail());
        dtoRetorno.setTelefone(salvo.getTelefone());

        return dtoRetorno;

    }

    public void deletarPorId(Long id) {
   if(clienteRepository.existsById(id)){
    clienteRepository.deleteById(id);
   } else{
    throw new RuntimeException("Cliente não encontrado");
   }
}

public ClienteRequestDTO buscarPorId(String id){
    
}


}


