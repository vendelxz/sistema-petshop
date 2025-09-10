package br.wendel.petshop.dtos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import br.wendel.petshop.entity.Cliente;
import br.wendel.petshop.enums.TipoPet;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetRequestDTO {

    @NotBlank(message = "Nome obrigatório")
    @NotNull
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    private Integer idade;

    private String raca;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cliente_nome")
    private Cliente cliente;

}
