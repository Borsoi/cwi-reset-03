package br.com.cwi.reset.guilhermeborsoi.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class DiretorRequest {

    @NotEmpty (message = "Campo obrigatório Não Informado. Favor Informar o campo nome")
    private String nome;
    @NotNull(message = "Campo Obrigatório não Informado. Favor informar o campo data de Nascimento")
    @Past(message = "Não é possível cadastrar diretores não nascidos")
    private LocalDate dataNascimento;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo ano de Inicio da Atividade")
    private Integer anoInicioAtividade;

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
