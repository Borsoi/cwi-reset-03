package br.com.cwi.reset.guilhermeborsoi.domain;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Filme {

    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> genero;
    private Diretor diretor;
    private Estudio estudio;
    private List<Personagem> personagens;
    private String resumo;

    public Filme(Integer id, String nome, Integer anoLancamento, String capaFilme, List<Genero> genero,
                 Diretor diretor, Estudio estudio, List<Personagem> personagens, String resumo) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.genero = genero;
        this.diretor = diretor;
        this.estudio = estudio;
        this.personagens = personagens;
        this.resumo = resumo;
    }

    public Integer getId() {
        return id;
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

    public Diretor getDiretor() {
        return diretor;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public String getResumo() {
        return resumo;
    }
}

