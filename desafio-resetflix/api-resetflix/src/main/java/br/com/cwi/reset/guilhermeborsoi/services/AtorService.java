package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.exceptions.CampoNaoInformado;
import br.com.cwi.reset.guilhermeborsoi.requests.AtorRequest;

import java.time.LocalDate;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest) throws CampoNaoInformado {
            Ator ator = new Ator(fakeDatabase.recuperaAtores().size() + 1, atorRequest.getNome(), atorRequest.getDataNascimento(),
                    atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
            if (ator.getNome() == "" || ator.getNome() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo nome";
                throw new CampoNaoInformado(e);
            } else if (ator.getNome().indexOf(" ") == -1) {
                String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
                throw new CampoNaoInformado(e);
            } else if (ator == fakeDatabase.recuperaAtores()) {
                String e = "Já existe um ator cadastrado para o nome " + ator.getNome();
                throw new CampoNaoInformado(e);
            } else if (ator.getDataNascimento() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo data de nascimento";
                throw new CampoNaoInformado(e);
            } else if (ator.getDataNascimento() != LocalDate.now()) {
                String e = "Não é possível cadastrar atores não nascidos";
                throw new CampoNaoInformado(e);
            } else if (ator.getStatusCarreira() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo status carreira";
                throw new CampoNaoInformado(e);
            } else if (ator.getAnoInicioAtividade() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo ano de Inicio da Atividade";
                throw new CampoNaoInformado(e);
            } else if (ator.getAnoInicioAtividade() < ator.getDataNascimento().getYear()) {
                String e = "Ano de início de atividade inválido para o ator cadastrado";
                throw new CampoNaoInformado(e);
            } else
                fakeDatabase.persisteAtor(ator);


    }

}