package br.com.cwi.reset.guilhermeborsoi.domain;

import java.time.LocalDate;

public class Diretor {

    private Integer id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Integer anoInicioDeAtividade;

    public Diretor(Integer id, String nome, LocalDate dataDeNascimento, Integer anoInicioDeAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.anoInicioDeAtividade = anoInicioDeAtividade;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Integer getAnoInicioDeAtividade() {
        return anoInicioDeAtividade;
    }
}
