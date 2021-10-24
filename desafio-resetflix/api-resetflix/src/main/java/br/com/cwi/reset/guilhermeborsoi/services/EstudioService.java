package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.domain.Estudio;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.repository.EstudioRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

//    private FakeDatabase fakeDatabase;
//
//    public EstudioService(FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;
//    }

    //Demais Métodos

    public void criarEstudio(EstudioRequest estudioRequest) throws MensagemDeErro {
        for (Estudio estudio : estudioRepository.findAll()) {
            if (estudio.getNome().equals(estudioRequest.getNome())) {
                String e = "Já existe um estudio cadastrado para o nome: " + estudioRequest.getNome();
                throw new MensagemDeErro(e);
            }
        }

            Estudio estudio = new Estudio(estudioRequest.getNome(), estudioRequest.getDescricao(),
                    estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());

            estudioRepository.save(estudio);
        }

    public List<Estudio> consultarEstudios(String filtroNome) throws MensagemDeErro {
        if (estudioRepository.count() == 0) {
            String e = "Nenhum estúdio cadastrado, favor cadastar estúdios";
            throw new MensagemDeErro(e);
        }
        List<Estudio> estudiosLista = new ArrayList<>();
        for (Estudio estudio : estudioRepository.findAll()) {
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
        for (Estudio estudio : estudioRepository.findAll())
            if (id == estudio.getId()) {
                return estudio;
            }
            String e = "Nenhum estúdio encontrado com o parâmetro ID " + id + ", favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
    }
}