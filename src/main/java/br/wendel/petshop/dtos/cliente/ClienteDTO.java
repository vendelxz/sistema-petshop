package br.wendel.petshop.dtos.cliente;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.wendel.petshop.entity.Pet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "CPF obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    @NotNull
    private String cpf;

    @NotNull
    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    private String email;

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    private String telefone;

     private List<Pet> pets = new ArrayList<>();

}
