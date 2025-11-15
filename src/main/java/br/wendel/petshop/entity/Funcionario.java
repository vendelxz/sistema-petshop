package br.wendel.petshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import br.wendel.petshop.enums.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome Obrigatório")
    private String nome;

    
    @NotBlank(message = "CPF Obrigatório")
    @NotNull
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String cpf;

    @Enumerated(EnumType.STRING) 
    @NotNull(message = "Ter um cargo é obrigatório")
    private Cargo cargo;

    @NotNull
    @NotBlank(message = "Email para contato é obrigatório!")
    @Email
    private String email;

  
}
