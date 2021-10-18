package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.PersonagemRequest;
import br.com.cwi.reset.guilhermeborsoi.services.PersonagemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping ("/personagens")
public class PersonagemController {

    private PersonagemService personagemService;

    public PersonagemController (PersonagemRequest personagemRequest) {
        this.personagemService = new PersonagemService(FakeDatabase.getInstance());
    }

    // Demais Métodos

    @PostMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void cadastrarPersonagem(@RequestBody PersonagemRequest personagemRequest) throws MensagemDeErro {
        this.personagemService.cadastrarPersonagem(personagemRequest);
    }
}
