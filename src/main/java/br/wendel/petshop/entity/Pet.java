package br.wendel.petshop.entity;

import jakarta.persistence.*;

import br.wendel.petshop.enums.TipoPet;


@Entity
public class Pet {

    @Id
    private String id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    private Integer idade;

    private String raca;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;

    public Pet() {}

    public Pet(String nome, TipoPet tipo, Integer idade, String raca, Cliente cliente) {
        this.nome = nome;
        this.tipo = tipo;
        this.idade = idade;
        this.raca = raca;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPet getTipo() {
        return tipo;
    }

    public void setTipo(TipoPet tipo) {
        this.tipo = tipo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
