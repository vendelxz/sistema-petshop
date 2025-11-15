package br.wendel.petshop.dtos.funcionarios;

import br.wendel.petshop.enums.Cargo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class FuncionarioResponseDTO {

    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING) 
    private Cargo cargo;

    private String email;
}
