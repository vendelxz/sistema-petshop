package br.wendel.petshop.dtos.funcionarios;

import br.wendel.petshop.enums.Cargo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FuncionarioResponseDTO {

    private Long id;

    @NotBlank
    @NotNull
    private String nome;

    @Enumerated(EnumType.STRING) 
    @NotNull(message = "Ter um cargo é obrigatório")
    private Cargo cargo;
}
