package br.com.cwi.reset.guilhermeborsoi.controller;

import br.com.cwi.reset.guilhermeborsoi.domain.Estudio;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErroException;
import br.com.cwi.reset.guilhermeborsoi.requests.EstudioRequest;
import br.com.cwi.reset.guilhermeborsoi.services.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/estudios")
public class EstudioContoller {

    @Autowired
    private EstudioService estudioService;

    //Demais Métodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio (@RequestBody EstudioRequest estudioRequest) throws MensagemDeErroException {
        this.estudioService.criarEstudio (estudioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Estudio> consultarEstudios (@RequestParam String filtroNome) throws MensagemDeErroException {
        return this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudio consultarEstudio (@PathVariable Integer id) throws MensagemDeErroException {
        return this.estudioService.consultarEstudio(id);
    }
}
