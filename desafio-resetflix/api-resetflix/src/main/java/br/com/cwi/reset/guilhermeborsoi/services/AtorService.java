package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.StatusCarreira;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.repository.AtorRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtorService {

//    private FakeDatabase fakeDatabase;

    @Autowired
    private AtorRepository atorRepository;

//    public AtorService(FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;
//    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest) throws MensagemDeErro {

            for (Ator atores :atorRepository.findAll()) {
                if (atores.getNome().equals(atorRequest.getNome())) {
                    String e = "Já existe um diretor cadastrado para o nome " + atorRequest.getNome();
                    throw new MensagemDeErro(e);
                }
            }
            if (!atorRequest.getNome().contains(" ")) {
                String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
                throw new MensagemDeErro(e);
//            } else if (atorRequest.getDataNascimento().getYear() > LocalDate.now().getYear()) {
//                String e = "Não é possível cadastrar atores não nascidos";
//                throw new MensagemDeErro(e);
            } else if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
                String e = "Ano de início de atividade inválido para o ator cadastrado";
                throw new MensagemDeErro(e);
            }
            Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        atorRepository.save(ator);
    }

    public List listarAtoresEmAtividade (String filtroNome) throws MensagemDeErro {
        if (atorRepository.count() == 0) {
            String e = "Nenhum ator cadastrado, favor cadastrar atores";
            throw new MensagemDeErro(e);
        }
        List<Ator> atoresEmAtividade = new ArrayList<>();

        for (Ator ator : atorRepository.findAll()) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                if (filtroNome == null || filtroNome.equals("")) {
                   atoresEmAtividade.add(ator);
                } else {
                    if (ator.getNome().contains(filtroNome)) {
                        atoresEmAtividade.add(ator);
                    }
                }
            }
        }
        if (atoresEmAtividade.isEmpty()) {
            String e = "Ator não encontrato com o filtro " + filtroNome + ", favor informar outro filtro";
            throw new MensagemDeErro(e);
        }
        return atoresEmAtividade;
    }

    public Ator consultarAtor (Integer id) throws MensagemDeErro {
        if (id == null) {
            String e = ("Campo obrigatório não informado. Favor informar o campo ID" );
            throw new MensagemDeErro(e);
        }
        for (Ator ator : atorRepository.findAll()) {
            if (ator.getId() == id) {
                return ator;
            }
        }
        String e = ("Nenhum ator encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados");
        throw new MensagemDeErro(e);
    }


    public List consultarAtores () throws MensagemDeErro {
        if (atorRepository.count() == 0) {
            String e = "Nenhum ator cadastrado, favor cadastar atores";
            throw new MensagemDeErro(e);
        } else
        return atorRepository.findAll();
    }

}