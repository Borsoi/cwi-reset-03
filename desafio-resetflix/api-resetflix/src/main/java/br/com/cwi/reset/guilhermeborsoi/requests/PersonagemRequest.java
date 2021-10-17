package br.com.cwi.reset.guilhermeborsoi.requests;

import br.com.cwi.reset.guilhermeborsoi.domain.Atuacao;

public class PersonagemRequest {

    Integer atorID;
    String nomePersonagem;
    String descricaoPersonagem;
    Atuacao atuacao;

    public PersonagemRequest(Integer atorID, String nomePersonagem, String descricaoPersonagem, Atuacao atuacao) {
        this.atorID = atorID;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.atuacao = atuacao;
    }

    public Integer getAtorID() {
        return atorID;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public Atuacao getAtuacao() {
        return atuacao;
    }
}
