package br.wendel.petshop.repository;

import br.wendel.petshop.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
}
