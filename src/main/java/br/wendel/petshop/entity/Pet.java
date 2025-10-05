package br.wendel.petshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import br.wendel.petshop.enums.TipoPet;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome obrigatório")
    @NotNull
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    private int idade;

    private String raca;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
}
