package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.repository.PetRespository;

import java.util.List;

public class PetService {

    private PetRespository petRespository = new PetRespository();

    public Pet cadastrar (Pet pet) {
        Pet petExistente = petRespository.consultarPeloNome(pet.getNome());

        if (petExistente != null) {

        }
        petRespository.cadastrar(pet);
        return pet;
    }

    public List<Pet> listarTodos () {
        return petRespository.listarTodos();
    }

    public Pet buscarPeloNome (String nome) {
        return petRespository.consultarPeloNome(nome);
    }

    public void deletar (String nome) {
        Pet petCadastrado = buscarPeloNome(nome);
        if (petCadastrado != null) {
            petRespository.deletar(petCadastrado);
        }
    }

    public Pet atualizar (Pet pet) {
        Pet petCadastrado = buscarPeloNome(pet.getNome());
        if (petCadastrado == null) {

        }
        return petRespository.atualizar(pet);
    }
}
