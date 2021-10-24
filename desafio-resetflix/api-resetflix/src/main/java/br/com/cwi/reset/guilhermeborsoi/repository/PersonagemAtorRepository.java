package br.com.cwi.reset.guilhermeborsoi.repository;

import br.com.cwi.reset.guilhermeborsoi.domain.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {

}
