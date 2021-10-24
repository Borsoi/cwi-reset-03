package br.com.cwi.reset.projeto1.service;
import br.com.cwi.reset.projeto1.domain.Especie;
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
        Pet petExistente = petRespository.findByNome(pet.getNome());

        if (petExistente != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já cadastrado");
        }

        //Validando se a espécie já existe
//        Especie especie = especieRepository.findByNome(pet.getEspecie().getNome());
//        if (especie != null) {
//            pet.setEspecie(especie);
//        }

        return petRespository.save(pet);
    }

    public List<Pet> listarTodos () {
        return petRespository.findAll();
    }

    public Pet buscarPeloNome (String nome) throws PetNaoExistenteException {
        Pet pet = petRespository.findByNome(nome);

        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não encontrado");
        }
        return petRespository.findByNome(nome);
    }

    public void deletar (String nome) throws PetNaoExistenteException {
        Pet petCadastrado = buscarPeloNome(nome);

        if (petCadastrado == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não encontrado");
        }

        petRespository.delete(petCadastrado);
    }

    public Pet atualizar (Pet pet) throws PetNaoExistenteException {
        Pet petCadastrado = petRespository.findById(pet.getId()).orElse(null);

        if (petCadastrado == null) {
            throw new PetNaoExistenteException ("Pet com o ID " + pet.getId() + " não encontrado");
        }

        if(petRespository.existsById(pet.getId())) {
            throw new PetNaoExistenteException("Pet com o ID " + pet.getId() + " não encontrado");
        }
        return petRespository.save(pet);
    }

}
