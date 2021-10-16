package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import br.com.cwi.reset.primeiroprojetospring.exceptions.AvaliacaoForaDoPadraoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private static List<Filme> filmes = new ArrayList<>();

    public Filme consultarFilmes(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                return filme;
            }
        }
        return null;
    }

    public boolean consultarFilmeJaCadastradoPeloNome (Filme filme) {
        Filme filmeDoBanco = consultarFilmes(filme.getNome());
        if (filmeDoBanco != null && filmeDoBanco.getNome().equals(filme.getNome())) {
            return false;
        }
        return true;
    }

    @PostMapping
    public ResponseEntity <Filme> cadastrarfilme(@RequestBody Filme filme) throws AvaliacaoForaDoPadraoException {
        if (consultarFilmeJaCadastradoPeloNome(filme)) {
            filmes.add(filme);
            return ResponseEntity.ok(filme);
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping
    public List ListarFilme() {
        return filmes;
    }

    @GetMapping("/{nome}")
    public Filme consultaFilmePeloNome(@PathVariable String nome) {
        Filme filme = consultarFilmes(nome);

        if (filme == null) {
            return null;
        }
        return filme;
    }

    @DeleteMapping ("/{nome}")
    public void deletarFilme (@PathVariable String nome) {
        Filme filmeCadastrado = consultarFilmes(nome);
        if (filmeCadastrado != null) {
            filmes.remove(filmeCadastrado);
        }
    }

    @PutMapping
    public Filme atualizarFilme (@RequestBody Filme filme) {
        Filme filmeCadastrado = consultarFilmes(filme.getNome());
        if (filmeCadastrado != null) {
            filmes.remove(filmeCadastrado);
            filmes.add(filme);
        }
        return filme;
    }


}


