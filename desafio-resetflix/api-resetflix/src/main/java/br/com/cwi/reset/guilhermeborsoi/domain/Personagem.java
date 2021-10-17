package br.com.cwi.reset.guilhermeborsoi.domain;

public class Personagem {

    private Integer id;
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private Atuacao atuacao;

    public Personagem(Integer id, Ator ator, String nomePersonagem,
                      String descricaoPersonagem, Atuacao atuacao) {
        this.id = id;
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.atuacao = atuacao;
    }

    public Integer getId() {
        return id;
    }

    public Ator getAtor() {
        return ator;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public String getAtuacao() {
        return atuacao.getDescricao();
    }
}
