package br.wendel.petshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteResponseDTO {

    private Long id;

    @NotNull
    @NotBlank(message = "É preciso de um nome")
    private String nome;

    @NotBlank(message = "É obrigatório informar um telefone")
    @NotNull
    private String telefone;

    @NotBlank(message = "É preciso informar um email")
    @NotNull
    private String email;


}
