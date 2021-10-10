package br.com.cwi.reset.guilhermeborsoi.domain;

public enum StatusAtividade {

    EM_ATIVIDADE ("Em atividade"),
    ENCERRADO ("Encerrado");

    private String descricao;

    StatusAtividade(String descricao) {
        this.descricao = descricao;
    }
}
