package br.com.cwi.reset.guilhermeborsoi.domain;

public enum Atuacao {

    PRINCIPAL("Principal"),
    COADJUVANTE ("Coadjuvante");

    private String descricao;

    Atuacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
