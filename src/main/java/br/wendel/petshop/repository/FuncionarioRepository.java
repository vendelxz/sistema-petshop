package br.wendel.petshop.repository;

import br.wendel.petshop.entity.Funcionario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
     boolean existsByCpf(String cpf);
    Optional<Funcionario> findByCpf(String cpf);
}
