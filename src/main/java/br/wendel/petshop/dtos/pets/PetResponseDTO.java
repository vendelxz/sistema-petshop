package br.wendel.petshop.dtos.pets;
import com.fasterxml.jackson.annotation.JsonBackReference;

import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.enums.TipoPet;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetResponseDTO {

    private Long id;

    @NotBlank(message = "Nome obrigatório")
    @NotNull
    private String nome; 

    private TipoPet tipo;

    private int idade;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cliente_nome")
    private Cliente cliente;
    
}
