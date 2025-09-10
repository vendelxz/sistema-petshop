package br.wendel.petshop.service;
import br.wendel.petshop.dtos.ClienteDTO;
import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.exception.CpfExistsException;
import br.wendel.petshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service 
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
    Cliente cliente = new Cliente();
    if(existeCPF(clienteDTO.getCpf())){
       throw new CpfExistsException("CPF já cadastrado");
    }  
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        Cliente salvo = clienteRepository.save(cliente);

        ClienteDTO dtoRetorno = new ClienteDTO();
        dtoRetorno.setNome(salvo.getNome());
        dtoRetorno.setEmail(salvo.getEmail());
        dtoRetorno.setTelefone(salvo.getTelefone());

        return dtoRetorno;

    }
    
    
  
    public ClienteDTO buscarPorCpf(String cpf) {
    Cliente cliente = clienteRepository.findById(cpf)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    ClienteDTO dto = new ClienteDTO();
    dto.setNome(cliente.getNome());
    dto.setEmail(cliente.getEmail());
    dto.setTelefone(cliente.getTelefone());
    return dto;
}
    public void deletarPorId(String cpf) {
   if(existeCPF(cpf)){
    clienteRepository.deleteById(cpf);
   }
   throw new RuntimeException("Cliente não encontrado");
}

private boolean existeCPF(String cpf)  {
    return clienteRepository.existsById(cpf);
}

}


