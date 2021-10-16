package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @GetMapping
    public Filme getFilme() {
        Diretor diretor = new Diretor("Guilherme Borsoi", LocalDate.of(1997,04,20), 1, Genero.MASCULINO);

        Filme filme =  new Filme ("Loucura do Spring", "Enloquecendo com Spring",110, "2021",4, diretor);
        return filme;
    }

}
