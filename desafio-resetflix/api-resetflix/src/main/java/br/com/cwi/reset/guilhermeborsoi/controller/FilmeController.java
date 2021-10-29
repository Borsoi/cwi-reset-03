package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.domain.Filme;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErroException;
import br.com.cwi.reset.guilhermeborsoi.requests.FilmeRequest;
import br.com.cwi.reset.guilhermeborsoi.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cadastrarFilme (@RequestBody FilmeRequest filmeRequest) throws MensagemDeErroException {
        this.filmeService.cadastrarFilme(filmeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Filme> consultarFilmes (@RequestParam String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws MensagemDeErroException {
        return this.filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }

    @DeleteMapping ("/{id}")
    public void removerFilme (@PathVariable Integer id) throws MensagemDeErroException {
        this.filmeService.removerFilme(id);
    }

}
