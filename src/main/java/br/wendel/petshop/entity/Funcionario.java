package br.wendel.petshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import br.wendel.petshop.enums.Cargo;


@Entity
public class Funcionario {

    @Id
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String id;

    @NotBlank(message = "Nome Obrigatório")
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String cpf;

    @Enumerated(EnumType.STRING) 
    @NotNull(message = "Ter um cargo é obrigatório")
    private Cargo cargo;

    public Funcionario() {}

    public Funcionario(String id, String nome, String cpf, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }
}
