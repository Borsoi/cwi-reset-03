package br.com.cwi.reset.guilhermeborsoi.repository;

import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.StatusCarreira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    List<Ator> findAll ();

    Optional<Ator> findByNome (String nome);

    List<Ator> findByNomeAndStatusCarreira (String nome, StatusCarreira statusCarreira);

    List<Ator> findByStatusCarreira (StatusCarreira statusCarreira);

}
