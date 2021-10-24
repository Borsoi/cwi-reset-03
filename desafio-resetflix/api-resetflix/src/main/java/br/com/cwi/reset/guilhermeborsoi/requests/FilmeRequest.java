package br.com.cwi.reset.guilhermeborsoi.requests;

import br.com.cwi.reset.guilhermeborsoi.domain.Genero;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmeRequest {

    @NotEmpty (message = "Campo obrigatório não informado. Favor informar o campo Nome")
    String nome;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Ano de Lançamento")
    Integer anoLancamento;
    @NotEmpty (message = "Campo obrigatório não informado. Favor informar o campo Capa do Filme")
    String capaFilme;
    List <Genero> genero;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo DiretorID")
    Integer diretorID;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo EstudioID")
    Integer estudioID;
    @NotEmpty (message = "Campo obrigatório não informado. Favor informar o campo Resumo")
    String resumo;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Personagens")
    List <PersonagemAtorRequest> personagem;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> genero, Integer diretorID,
                        Integer estudioID, String resumo, List<PersonagemAtorRequest> personagem) {
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

    public List<PersonagemAtorRequest> getPersonagem() {
        return personagem;
    }
}
