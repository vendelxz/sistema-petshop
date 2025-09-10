package br.wendel.petshop.repository;

import br.wendel.petshop.entity.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
    Optional<Cliente> findByCpf(String cpf);
}
