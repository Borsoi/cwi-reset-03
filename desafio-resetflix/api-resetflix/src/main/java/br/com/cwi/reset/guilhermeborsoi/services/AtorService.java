package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.StatusCarreira;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest) throws MensagemDeErro {
            Ator ator = new Ator(fakeDatabase.recuperaAtores().size() + 1, atorRequest.getNome(), atorRequest.getDataNascimento(),
                    atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
            for (Ator atores :fakeDatabase.recuperaAtores()) {
                if (atores.getNome().equals(ator.getNome())) {
                    String e = "Campo obrigatório não informado. Favor informar o campo nome";
                    throw new MensagemDeErro(e);
                }
            }
            if (ator.getNome().equals("") || ator.getNome() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo nome";
                throw new MensagemDeErro(e);
            } else if (ator.getNome().indexOf(" ") == -1) {
                String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
                throw new MensagemDeErro(e);
            } else if (ator.getDataNascimento() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo data de nascimento";
                throw new MensagemDeErro(e);
            } else if (ator.getDataNascimento().getYear() > LocalDate.now().getYear()) {
                String e = "Não é possível cadastrar atores não nascidos";
                throw new MensagemDeErro(e);
            } else if (ator.getStatusCarreira() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo status carreira";
                throw new MensagemDeErro(e);
            } else if (ator.getAnoInicioAtividade() == null) {
                String e = "Campo obrigatório não informado. Favor informar o campo ano de Inicio da Atividade";
                throw new MensagemDeErro(e);
            } else if (ator.getAnoInicioAtividade() < ator.getDataNascimento().getYear()) {
                String e = "Ano de início de atividade inválido para o ator cadastrado";
                throw new MensagemDeErro(e);
            } else
                fakeDatabase.persisteAtor(ator);
    }

    public List listarAtoresEmAtividade (String filtroNome) throws MensagemDeErro {
        if (fakeDatabase.recuperaAtores().isEmpty()) {
            String e = "Nenhum ator cadastrado, favor cadastrar atores";
            throw new MensagemDeErro(e);
        }
        List<Ator> atoresEmAtividade = new ArrayList<>();

        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                if (filtroNome == null || filtroNome.equals("")) {
                   atoresEmAtividade.add(ator);
                } else {
                    if (ator.getNome().indexOf(filtroNome) != -1) {
                        atoresEmAtividade.add(ator);
                    }
                }
            }
        }
        if (atoresEmAtividade.isEmpty()) {
            String e = "Ator não encontrato com o filtro {filtro}, favor informar outro filtro";
            throw new MensagemDeErro(e);
        }
        return atoresEmAtividade;
    }

    public Ator consultarAtor (Integer id) throws MensagemDeErro {
        if (id == null) {
            String e = ("Campo obrigatório não informado. Favor informar o campo ID" );
            throw new MensagemDeErro(e);
        }
        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (ator.getId() == id) {
                return ator;
            }
        }
        String e = ("Nenhum ator encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados");
        throw new MensagemDeErro(e);
    }


    public List consultarAtores () throws MensagemDeErro {
        if (fakeDatabase.recuperaAtores().isEmpty()) {
            String e = "Nenhum ator cadastrado, favor cadastar atores";
            throw new MensagemDeErro(e);
        } else
        return fakeDatabase.recuperaAtores();
    }

}