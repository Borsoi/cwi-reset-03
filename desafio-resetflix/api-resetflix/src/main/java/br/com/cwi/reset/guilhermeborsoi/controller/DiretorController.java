package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.DiretorRequest;
import br.com.cwi.reset.guilhermeborsoi.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor (@RequestBody @Valid DiretorRequest diretorRequest) throws MensagemDeErro {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List listarDiretores (@RequestParam String filtroNome) throws MensagemDeErro {
        return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Diretor consultarDiretor (@PathVariable Integer id) throws MensagemDeErro {
        return this.diretorService.consultarDiretor(id);
    }


}
