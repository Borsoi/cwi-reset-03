package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.AtorRequest;
import br.com.cwi.reset.guilhermeborsoi.services.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;


    //demais métodos
    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void cadastrarAtor (@RequestBody @Valid AtorRequest atorRequest) throws MensagemDeErro {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping ("/em-atividade")
    @ResponseStatus (HttpStatus.CREATED)
    public List listarAtoresEmAtividade (@RequestParam String filtroNome) throws MensagemDeErro {
       return this.atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Ator consultarAtor (@PathVariable Integer id) throws MensagemDeErro {
        return this.atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus (HttpStatus.CREATED)
    public List consultarAtores () throws MensagemDeErro {
        return atorService.consultarAtores();
    }


}
