package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.AtorRequest;
import br.com.cwi.reset.guilhermeborsoi.services.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/atores")
public class AtorController {

    private AtorService atorService;

    public  AtorController () {
        this.atorService = new AtorService((FakeDatabase.getInstance()));
    }

    //demais métodos
    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void criarAtor (@RequestBody AtorRequest atorRequest) throws MensagemDeErro {
        this.atorService.criarAtor(atorRequest);
    }
}
