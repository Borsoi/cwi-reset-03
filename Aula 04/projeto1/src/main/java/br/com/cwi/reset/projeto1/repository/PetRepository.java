package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

    Pet consultarPeloNome(String nome);
    Pet cadastrar (Pet pet);
    void deletar(Pet pet);
    Pet atualizar(Pet pet);
    List<Pet> listarTodos();

}