package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErroException;
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
    public void cadastrarAtor (@RequestBody @Valid AtorRequest atorRequest) throws MensagemDeErroException {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping ("/em-atividade")
    @ResponseStatus (HttpStatus.CREATED)
    public List<Ator> listarAtoresEmAtividade (@RequestParam String filtroNome) throws MensagemDeErroException {
       return this.atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Ator consultarAtor (@PathVariable Integer id) throws MensagemDeErroException {
        return this.atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus (HttpStatus.CREATED)
    public List<Ator> consultarAtores () throws MensagemDeErroException {
        return atorService.consultarAtores();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void atualizarAtor(@PathVariable Integer id, @RequestBody @Valid AtorRequest atorRequest) throws MensagemDeErroException {
        this.atorService.atualizar(id, atorRequest);
    }

    @DeleteMapping ("/{id}")
    public void deletar (@PathVariable Integer id) throws MensagemDeErroException {
        this.atorService.deletar(id);
    }




}
