package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorJaExistenteException;
import br.com.cwi.reset.projeto1.exception.AtorNaoExistenteException;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ator cadastrar (@RequestBody Ator ator) throws AtorJaExistenteException {
        return atorService.cadastrar(ator);
    }

    @GetMapping("/{nome}")
    public Ator buscarPeloNome (@PathVariable String nome) throws AtorNaoExistenteException {
        return atorService.buscarPeloNome(nome);
    }

    @GetMapping("/{numeroOscar}")
    public List<Ator> buscarPeloNumeroDeOscars (@PathVariable Integer numeroOscars) throws AtorNaoExistenteException {
        return atorService.findByNumeroOscars(numeroOscars);
    }

    @DeleteMapping("/{nome}")
    public void deletar (@PathVariable String nome) throws AtorNaoExistenteException {
        atorService.deletar(nome);
    }

    @GetMapping("/filtro-duplo")
    public List<Ator> buscarPorFiltro (Integer oscars, Integer anoNascimento) {
        return atorService.buscarPorFiltro(oscars, anoNascimento);
    }


}
