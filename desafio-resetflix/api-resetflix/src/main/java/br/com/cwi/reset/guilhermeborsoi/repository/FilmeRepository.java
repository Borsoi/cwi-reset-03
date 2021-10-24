package br.com.cwi.reset.guilhermeborsoi.repository;

import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.domain.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

    List<Filme> findByDiretor (Diretor diretor);

}
    
