package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService petService = new PetService();

    @GetMapping
    public List<Pet> listarTodos () {
        return petService.listarTodos();
    }

    @GetMapping("/{nome}")
    public Pet consultarPeloNome (@PathVariable String nome) {
        return petService.buscarPeloNome(nome);
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) {
        petService.cadastrar(pet);
        return pet;
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) {
        petService.atualizar(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) {
        petService.deletar(nome);

        }

}
