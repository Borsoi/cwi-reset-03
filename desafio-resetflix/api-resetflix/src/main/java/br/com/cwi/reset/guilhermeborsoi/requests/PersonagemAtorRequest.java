package br.com.cwi.reset.guilhermeborsoi.requests;

import br.com.cwi.reset.guilhermeborsoi.domain.TipoAtuacao;

public class PersonagemAtorRequest {

    Integer atorID;
    String nomePersonagem;
    String descricaoPersonagem;
    TipoAtuacao atuacao;

    public PersonagemAtorRequest(Integer atorID, String nomePersonagem, String descricaoPersonagem, TipoAtuacao atuacao) {
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

    public TipoAtuacao getAtuacao() {
        return atuacao;
    }
}
