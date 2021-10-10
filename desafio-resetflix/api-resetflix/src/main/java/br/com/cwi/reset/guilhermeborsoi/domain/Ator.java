package br.com.cwi.reset.guilhermeborsoi.domain;

import java.time.LocalDate;

public class Ator {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public Ator(Integer id, String nome, LocalDate dataNascimento,
                StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    //Getters
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void dadosPessoais () {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Status de Carreira: " + getStatusCarreira());
        System.out.println("Ano do Inicio da Atividade: " + getAnoInicioAtividade());
    }

}
