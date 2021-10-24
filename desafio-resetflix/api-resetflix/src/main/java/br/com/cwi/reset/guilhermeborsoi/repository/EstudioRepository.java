package br.com.cwi.reset.guilhermeborsoi.repository;

import br.com.cwi.reset.guilhermeborsoi.domain.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

}
