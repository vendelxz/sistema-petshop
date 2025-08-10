package br.wendel.petshop.controller;
import br.wendel.petshop.entity.Pet;
import br.wendel.petshop.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public List<Pet> listarPets(){
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pet> BuscarPorId(@PathVariable String id){
        return petRepository.findById(id);
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody @Valid Pet pet){
        return petRepository.save(pet);
    }

    @PutMapping("/{id}")
    public Pet atualizarPet(@PathVariable String id, @RequestBody @Valid Pet petAtualizado) {
        return petRepository.findById(id)
                .map(pet -> {
                    pet.setNome(petAtualizado.getNome());
                    pet.setTipo(petAtualizado.getTipo());
                    pet.setIdade(petAtualizado.getIdade());
                    pet.setRaca(petAtualizado.getRaca());
                    pet.setCliente(petAtualizado.getCliente());
                    return petRepository.save(pet);
                })
                .orElseGet(() -> {
                    petAtualizado.setId(id);
                    return petRepository.save(petAtualizado);
                });
    }

    @DeleteMapping("/{id}")
    public void deletarPet(@PathVariable String id) {
        petRepository.deleteById(id);
    }

}
