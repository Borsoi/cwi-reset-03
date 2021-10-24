package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Estudio;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    //Demais Métodos

    public void criarEstudio(EstudioRequest estudioRequest) throws MensagemDeErro {
        for (Estudio estudio : fakeDatabase.recuperaEstudios()) {
            if (estudio.getNome().equals(estudioRequest)) {
                String e = "Já existe um estudio cadastrado para o nome: " + estudioRequest.getNome();
                throw new MensagemDeErro(e);
            }
        }

//        } if (estudioRequest.getDataCriacao().getYear() > LocalDate.now().getYear()) {
//            String e = "Não é possível cadastrar estúdios do futuro";
//            throw new MensagemDeErro(e);

        } else {
            Estudio estudio = new Estudio(fakeDatabase.recuperaEstudios().size() + 1, estudioRequest.getNome(), estudioRequest.getDescricao(),
                    estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());

            fakeDatabase.persisteEstudio(estudio);
        }
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws MensagemDeErro {
        if (fakeDatabase.recuperaEstudios().isEmpty()) {
            String e = "Nenhum estúdio cadastrado, favor cadastar estúdios";
            throw new MensagemDeErro(e);
        }
        List<Estudio> estudiosLista = new ArrayList<>();
        for (Estudio estudio : fakeDatabase.recuperaEstudios()) {
            if (filtroNome.equals("") || filtroNome == null) {
                estudiosLista.add(estudio);
            } else if (estudio.getNome().contains(filtroNome)) {
                estudiosLista.add(estudio);
            } else {
                String e = "Estúdio não encontrato com o filtro " + filtroNome + ", favor informar outro filtro";
                throw new MensagemDeErro(e);
            }
        }
        return estudiosLista;
    }

    public Estudio consultarEstudio(Integer id) throws MensagemDeErro {
        if (id == null) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErro(e);
        }
        for (Estudio estudio : fakeDatabase.recuperaEstudios())
            if (id == estudio.getId()) {
                return estudio;
            }
            String e = "Nenhum estúdio encontrado com o parâmetro ID " + id + ", favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
    }
}