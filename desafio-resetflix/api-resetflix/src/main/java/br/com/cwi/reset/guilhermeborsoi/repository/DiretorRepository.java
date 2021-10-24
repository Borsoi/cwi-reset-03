package br.com.cwi.reset.guilhermeborsoi.repository;

import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends CrudRepository <Diretor, Integer> {


}
