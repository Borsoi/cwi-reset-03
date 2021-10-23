package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> listarTodos () {
        return petService.listarTodos();
    }

    @GetMapping("/{nome}")
    public Pet consultarPeloNome (@PathVariable String nome) throws PetNaoExistenteException {
        return petService.buscarPeloNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet cadastrarPet(@RequestBody Pet pet) throws PetJaExistenteException {
        return petService.cadastrar(pet);
    }

    @PutMapping
    public Pet atualizarPet(@RequestBody Pet pet) throws PetNaoExistenteException {
        return petService.atualizar(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws PetNaoExistenteException {
        petService.deletar(nome);
    }

}
