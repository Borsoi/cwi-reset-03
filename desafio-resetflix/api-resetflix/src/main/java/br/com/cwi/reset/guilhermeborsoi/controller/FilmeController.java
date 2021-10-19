package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Filme;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.FilmeRequest;
import br.com.cwi.reset.guilhermeborsoi.services.FilmeService;
import br.com.cwi.reset.guilhermeborsoi.services.PersonagemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/filmes")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController () {
        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }

    // Demais Métodos

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cadastrarFilme (@RequestBody FilmeRequest filmeRequest) throws MensagemDeErro {
        this.filmeService.cadastrarFilme(filmeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Filme> consultarFilmes (@RequestParam String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws MensagemDeErro {
        return this.filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }

}
