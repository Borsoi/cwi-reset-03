package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.domain.*;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.repository.DiretorRepository;
import br.com.cwi.reset.guilhermeborsoi.repository.EstudioRepository;
import br.com.cwi.reset.guilhermeborsoi.repository.FilmeRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.FilmeRequest;
import br.com.cwi.reset.guilhermeborsoi.requests.PersonagemAtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private DiretorRepository diretorRepository;
    @Autowired
    private EstudioRepository estudioRepository;
    private PersonagemService personagemService;


//    private FakeDatabase fakeDatabase;

//    public FilmeService(FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;
//        this.personagemService = new PersonagemService(fakeDatabase);
//    }

    //Demais Métodos

    public void cadastrarFilme(FilmeRequest filmeRequest) throws MensagemDeErro {
        for (Filme filmes : filmeRepository.findAll()) {
            if (filmeRequest.getNome().equals(filmes.getNome())) {
                String e = "Não é possível adicionar um filme com o mesmo nome";
                throw new MensagemDeErro(e);
            }
        }

        Diretor diretorPeloID = null;
        for (Diretor diretor : diretorRepository.findAll()) {
            if (filmeRequest.getDiretorID() == diretor.getId()) {
                diretorPeloID = diretor;
            }
        }
        if (diretorPeloID == null) {
            String e = "Nenhum diretor encontrado com o parâmetro ID " + filmeRequest.getDiretorID() + ", favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }

        Estudio estudioPeloID = null;
        for (Estudio estudio : estudioRepository.findAll()) {
            if (filmeRequest.getEstudioID() == estudio.getId()) {
                estudioPeloID = estudio;
            }
        }
        if (estudioPeloID == null) {
            String e = "Nenhum estudio encontrado com o parâmetro ID " + filmeRequest.getEstudioID() + ", favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }

        List<PersonagemAtor> personagens = new ArrayList<>();
        for (PersonagemAtorRequest personagemRequest : filmeRequest.getPersonagem()) {
            personagens.add(personagemService.cadastrarPersonagem(personagemRequest));
        }

        Filme filme = new Filme(filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(),
                filmeRequest.getGenero(), estudioPeloID, diretorPeloID, personagens, filmeRequest.getResumo());

        filmeRepository.save(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws MensagemDeErro {
        if (filmeRepository.count() == 0) {
            String e = "Nenhum filme cadastrado, favor cadastar filme";
            throw new MensagemDeErro(e);
        }

        List<Filme> filmes = new ArrayList<>();
        for (Filme filme : filmeRepository.findAll()) {
            boolean temPersonagemOuAtor = false;
            for (PersonagemAtor personagemAtor : filme.getPersonagens()) {
                if (personagemAtor.getNomePersonagem().contains(nomePersonagem) || personagemAtor.getAtor().getNome().contains(nomeAtor)) {
                    temPersonagemOuAtor = true;
                    break;
                }
            }
            if ((nomeFilme == null || nomeFilme.equals("")) && (nomeDiretor == null || nomeDiretor.equals("")) && (nomePersonagem == null || nomePersonagem.equals("")) && (nomeAtor == null || nomeAtor.equals(""))) {
                filmes.add(filme);
            } else if (filme.getNome().contains(nomeFilme) || filme.getDiretor().getNome().contains(nomeDiretor) || temPersonagemOuAtor) {
                filmes.add(filme);

            } else {
                String e = "Ator não encontrato com os filtros nomeFilme " + nomeFilme + ", nomeDiretor " + nomeDiretor + ", nomePersonagem " + nomePersonagem + ", nomeAtor " + nomeAtor + ", favor informar outros filtros";
                throw new MensagemDeErro(e);
            }
        }
        return filmes;
    }


}
