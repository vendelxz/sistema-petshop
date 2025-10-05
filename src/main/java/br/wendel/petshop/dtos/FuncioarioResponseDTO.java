package br.wendel.petshop.dtos;

import br.wendel.petshop.enums.Cargo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FuncioarioResponseDTO {

    private Long id;

    @NotBlank
    @NotNull
    private String nome;

     @Enumerated(EnumType.STRING) 
    @NotNull(message = "Ter um cargo é obrigatório")
    private Cargo cargo;
}
