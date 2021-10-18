package br.com.cwi.reset.guilhermeborsoi.requests;

import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.domain.Estudio;
import br.com.cwi.reset.guilhermeborsoi.domain.Genero;

import javax.swing.*;
import java.util.List;

public class FilmeRequest {

    String nome;
    Integer anoLancamento;
    String capaFilme;
    List <Genero> genero;
    Integer diretorID;
    Integer estudioID;
    String resumo;
    List <PersonagemRequest> personagem;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> genero, Integer diretorID,
                        Integer estudioID, String resumo, List<PersonagemRequest> personagem) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.genero = genero;
        this.diretorID = diretorID;
        this.estudioID = estudioID;
        this.resumo = resumo;
        this.personagem = personagem;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGenero() {
        return genero;
    }

    public Integer getDiretorID() {
        return diretorID;
    }

    public Integer getEstudioID() {
        return estudioID;
    }

    public String getResumo() {
        return resumo;
    }

    public List<PersonagemRequest> getPersonagem() {
        return personagem;
    }
}
