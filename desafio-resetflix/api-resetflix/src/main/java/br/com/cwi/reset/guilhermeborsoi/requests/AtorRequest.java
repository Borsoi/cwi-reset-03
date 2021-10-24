package br.com.cwi.reset.guilhermeborsoi.requests;

import br.com.cwi.reset.guilhermeborsoi.domain.StatusCarreira;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class AtorRequest {
    @NotEmpty (message = "Campo obrigatório Não Informado. Favor Informar o campo nome")
    private String nome;
    @NotNull(message = "Campo Obrigatório não Informado. Favor informar o campo data de Nascimento")
    @Past(message = "Não é possível cadastrar atores não nascidos")
    private LocalDate dataNascimento;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo status carreira")
    private StatusCarreira statusCarreira;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo ano de Inicio da Atividade")
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
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

}
