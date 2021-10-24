package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.*;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.FilmeRequest;
import br.com.cwi.reset.guilhermeborsoi.requests.PersonagemAtorRequest;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private PersonagemService personagemService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.personagemService = new PersonagemService(fakeDatabase);
    }

    //Demais Métodos

    public void cadastrarFilme(FilmeRequest filmeRequest) throws MensagemDeErro {
        for (Filme filmes : fakeDatabase.recuperaFilmes()) {
            if (filmeRequest.getNome().equals(filmes.getNome())) {
                String e = "Não é possível adicionar um filme com o mesmo nome";
                throw new MensagemDeErro(e);
            }
        }

        Diretor diretorPeloID = null;
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (filmeRequest.getDiretorID() == diretor.getId()) {
                diretorPeloID = diretor;
            }
        }
        if (diretorPeloID == null) {
            String e = "Nenhum diretor encontrado com o parâmetro ID " + filmeRequest.getDiretorID() + ", favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }

        Estudio estudioPeloID = null;
        for (Estudio estudio : fakeDatabase.recuperaEstudios()) {
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

        Filme filme = new Filme(fakeDatabase.recuperaFilmes().size() + 1, filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(),
                filmeRequest.getGenero(), diretorPeloID, estudioPeloID, personagens, filmeRequest.getResumo());

        fakeDatabase.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws MensagemDeErro {
        if (fakeDatabase.recuperaFilmes().isEmpty()) {
            String e = "Nenhum filme cadastrado, favor cadastar filme";
            throw new MensagemDeErro(e);
        }

        List<Filme> filmes = new ArrayList<>();
        for (Filme filme : fakeDatabase.recuperaFilmes()) {
            boolean temPersonagemOuAtor = false;
            for (Personagem personagem : filme.getPersonagens()) {
                if (personagem.getNomePersonagem().contains(nomePersonagem) || personagem.getAtor().getNome().contains(nomeAtor)) {
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
