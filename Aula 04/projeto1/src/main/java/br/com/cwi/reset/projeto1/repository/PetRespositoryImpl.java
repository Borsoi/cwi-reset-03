//package br.com.cwi.reset.projeto1.repository;
//import br.com.cwi.reset.projeto1.domain.Pet;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PetRespositoryImpl implements PetRepository {
//
//    private List<Pet> pets = new ArrayList<>();
//
//    public Pet consultarPeloNome(String nome) {
//        for (Pet pet : pets) {
//            if (pet.getNome().equals(nome)) {
//                return pet;
//            }
//        }
//        return null;
//    }
//
//    public Pet cadastrar (Pet pet) {
//        pets.add(pet);
//        return pet;
//    }
//
//    public void deletar(Pet pet) {
//        pets.remove(pet);
//    }
//
//    public Pet atualizar(Pet pet) {
//        Pet petExistente = consultarPeloNome(pet.getNome());
//
//        if (petExistente != null) {
//            pets.remove(petExistente);
//            pets.add(pet);
//        }
//        return petExistente;
//    }
//
//    public List<Pet> listarTodos() {
//        return pets;
//    }
//}
