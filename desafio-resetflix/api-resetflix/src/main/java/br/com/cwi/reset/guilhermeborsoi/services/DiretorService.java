package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.CampoNaoInformado;
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

    public void cadastrarDiretor (DiretorRequest diretorRequest) throws CampoNaoInformado {
        Diretor diretor = new Diretor(fakeDatabase.recuperaDiretores().size() + 1, diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),diretorRequest.getAnoInicioAtividade());
        for (Diretor diretores :fakeDatabase.recuperaDiretores()) {
            if (diretores.getNome().equals(diretor.getNome())) {
                String e = "Já existe um diretor cadastrado para o nome " + diretor.getNome();
                throw new CampoNaoInformado(e);
            }
        }
        if (diretor.getNome().equals("") || diretor.getNome() == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo nome";
            throw new CampoNaoInformado(e);
        } else if (diretor.getNome().indexOf(" ") == -1) {
            String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
            throw new CampoNaoInformado(e);
        } else if (diretor.getDataDeNascimento() == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo data de nascimento";
            throw new CampoNaoInformado(e);
        } else if (diretor.getDataDeNascimento().getYear() > LocalDate.now().getYear()) {
            String e = "Não é possível cadastrar atores não nascidos";
            throw new CampoNaoInformado(e);
        } else if (diretor.getAnoInicioDeAtividade() == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo ano de Inicio da Atividade";
            throw new CampoNaoInformado(e);
        } else if (diretor.getAnoInicioDeAtividade() < diretor.getDataDeNascimento().getYear()) {
            String e = "Ano de início de atividade inválido para o ator cadastrado";
            throw new CampoNaoInformado(e);
        } else
            fakeDatabase.persisteDiretor(diretor);
    }

    public List listarDiretores (String filtroNome) throws CampoNaoInformado {
        if (fakeDatabase.recuperaDiretores().isEmpty()) {
            String e = "Nenhum diretor cadastrado, favor cadastrar diretores";
            throw new CampoNaoInformado(e);
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
                throw new CampoNaoInformado(e);
            }
        }
        return diretores;
    }

    public Diretor consultarDiretor (Integer id) throws CampoNaoInformado {
        if (id == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new CampoNaoInformado(e);
        }
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (id == diretor.getId()) {
                return diretor;
            }
        }
        String e = "Nenhum diretor encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.";
        throw new CampoNaoInformado(e);
    }


    }

