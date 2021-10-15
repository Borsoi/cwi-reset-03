package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.DiretorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws MensagemDeErro {

        for (Diretor diretores : fakeDatabase.recuperaDiretores()) {
            if (diretores.getNome().equals(diretorRequest.getNome())) {
                String e = "Já existe um diretor cadastrado para o nome " + diretorRequest.getNome();
                throw new MensagemDeErro(e);
            }
        }
        if (diretorRequest.getNome().equals("") || diretorRequest.getNome() == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo nome";
            throw new MensagemDeErro(e);
        } else if (diretorRequest.getNome().indexOf(" ") == -1) {
            String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
            throw new MensagemDeErro(e);
        } else if (diretorRequest.getDataNascimento() == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo data de nascimento";
            throw new MensagemDeErro(e);
        } else if (diretorRequest.getDataNascimento().getYear() > LocalDate.now().getYear()) {
            String e = "Não é possível cadastrar atores não nascidos";
            throw new MensagemDeErro(e);
        } else if (diretorRequest.getAnoInicioAtividade() == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo ano de Inicio da Atividade";
            throw new MensagemDeErro(e);
        } else if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()) {
            String e = "Ano de início de atividade inválido para o ator cadastrado";
            throw new MensagemDeErro(e);
        }

        Diretor diretor = new Diretor(fakeDatabase.recuperaDiretores().size() + 1, diretorRequest.getNome(),
            diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
    }


    public List listarDiretores (String filtroNome) throws MensagemDeErro {
        if (fakeDatabase.recuperaDiretores().isEmpty()) {
            String e = "Nenhum diretor cadastrado, favor cadastrar diretores";
            throw new MensagemDeErro(e);
        }
        List <Diretor> diretores = new ArrayList<>();
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (filtroNome.equals("") || filtroNome == null) {
                diretores.add(diretor);
            } else if (diretor.getNome().indexOf(filtroNome) != - 1) {
                    diretores.add(diretor);
            }
            else {
                String e = "Diretor não encontrato com o filtro" + filtroNome + ", favor informar outro filtro";
                throw new MensagemDeErro(e);
            }
        }
        return diretores;
    }

    public Diretor consultarDiretor (Integer id) throws MensagemDeErro {
        if (id == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErro(e);
        }
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (id == diretor.getId()) {
                return diretor;
            }
        }
        String e = "Nenhum diretor encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.";
        throw new MensagemDeErro(e);
    }


    }

