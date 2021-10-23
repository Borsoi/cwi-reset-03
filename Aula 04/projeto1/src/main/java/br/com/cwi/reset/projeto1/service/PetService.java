package br.com.cwi.reset.projeto1.service;
import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRespository;

    public Pet cadastrar (Pet pet) throws PetJaExistenteException {
        Pet petExistente = petRespository.consultarPeloNome(pet.getNome());

        if (petExistente != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já cadastrado");
        }
        return petRespository.cadastrar(pet);
    }

    public List<Pet> listarTodos () {
        return petRespository.listarTodos();
    }

    public Pet buscarPeloNome (String nome) throws PetNaoExistenteException {
        Pet pet = petRespository.consultarPeloNome(nome);

        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não encontrado");
        }
        return petRespository.consultarPeloNome(nome);
    }

    public void deletar (String nome) throws PetNaoExistenteException {
        Pet petCadastrado = buscarPeloNome(nome);

        if (petCadastrado == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não encontrado");
        }

        petRespository.deletar(petCadastrado);
    }

    public Pet atualizar (Pet pet) throws PetNaoExistenteException {
        Pet petCadastrado = buscarPeloNome(pet.getNome());

        if (petCadastrado == null) {
            throw new PetNaoExistenteException ("Pet com o nome " + pet.getNome() + " não encontrado");
        }
        return petRespository.atualizar(pet);
    }

}
