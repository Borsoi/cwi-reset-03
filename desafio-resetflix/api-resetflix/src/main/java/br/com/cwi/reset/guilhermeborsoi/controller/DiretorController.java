package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.DiretorRequest;
import br.com.cwi.reset.guilhermeborsoi.services.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController () {
        this.diretorService = new DiretorService((FakeDatabase.getInstance()));
    }

    //demais métodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor (@RequestBody DiretorRequest diretorRequest) throws MensagemDeErro {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List <Diretor> listarDiretores (@RequestParam String filtroNome) throws MensagemDeErro {
        return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Diretor consultarDiretor (@PathVariable Integer id) throws MensagemDeErro {
        return this.diretorService.consultarDiretor(id);
    }


}
