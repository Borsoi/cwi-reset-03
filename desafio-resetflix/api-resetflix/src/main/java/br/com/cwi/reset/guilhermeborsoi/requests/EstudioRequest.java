package br.com.cwi.reset.guilhermeborsoi.requests;

import br.com.cwi.reset.guilhermeborsoi.domain.StatusAtividade;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class EstudioRequest {

    @NotEmpty (message = "Campo obrigatório Não Informado. Favor Informar o campo nome")
    String nome;
    @NotEmpty (message = "Campo obrigatório Não Informado. Favor Informar o campo descrição")
    String descricao;
    @NotNull(message = "Campo Obrigatório não Informado. Favor informar o campo data de Nascimento")
    @Past(message = "Não é possível cadastrar estúdios do futuro")
    LocalDate dataCriacao;
    @NotNull(message = "Campo Obrigatório não Informado. Favor informar o campo Status da Atividade")
    StatusAtividade statusAtividade;

    public EstudioRequest(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }
}
