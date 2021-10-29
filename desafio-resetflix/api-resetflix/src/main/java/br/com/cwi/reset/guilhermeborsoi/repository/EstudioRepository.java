package br.com.cwi.reset.guilhermeborsoi.repository;

import br.com.cwi.reset.guilhermeborsoi.domain.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    List<Estudio> findAll ();

    Optional<Estudio> findByNome (String nome);

    List<Estudio> findByNomeContains (String nome);



}
