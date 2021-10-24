package br.com.cwi.reset.guilhermeborsoi.repository;

import br.com.cwi.reset.guilhermeborsoi.domain.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

}
    
