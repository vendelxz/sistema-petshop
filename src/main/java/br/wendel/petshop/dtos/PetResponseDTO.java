package br.wendel.petshop.dtos;
import br.wendel.petshop.enums.TipoPet;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PetResponseDTO {

    private Long id;

    @NotBlank(message = "Nome obrigatório")
    @NotNull
    private String nome; 

    private tipoPet tipo;

    private int idade;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cliente_nome")
    private Cliente cliente;
    
}
