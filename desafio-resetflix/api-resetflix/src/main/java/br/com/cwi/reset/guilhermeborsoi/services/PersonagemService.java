package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.Filme;
import br.com.cwi.reset.guilhermeborsoi.domain.PersonagemAtor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.repository.AtorRepository;
import br.com.cwi.reset.guilhermeborsoi.repository.FilmeRepository;
import br.com.cwi.reset.guilhermeborsoi.repository.PersonagemAtorRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.FilmeRequest;
import br.com.cwi.reset.guilhermeborsoi.requests.PersonagemAtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;
    @Autowired
    private AtorRepository atorRepository;
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private FilmeService filmeService;


    //Demais Métodos

    public PersonagemAtor cadastrarPersonagem(PersonagemAtorRequest personagemRequest, FilmeRequest filmeRequest) throws MensagemDeErro {
        Ator atorPeloID = null;
        for (Ator ator : atorRepository.findAll()) {
            if (personagemRequest.getAtorID().equals(ator.getId())) {
                for (PersonagemAtor personagens : personagemAtorRepository.findAll()) {
                    if (personagemRequest.getNomePersonagem().equals(personagens.getNomePersonagem()))
                        for (Filme filme : filmeRepository.findAll()) {
                            if (filme.getNome().equals(filmeRequest.getNome())) {
                                String e = "Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme";
                                throw new MensagemDeErro(e);
                        }
                    }
                }

            }
            atorPeloID = ator;
        }

         if (atorPeloID == null) {
            String e = "Nenhum ator encontrado com o parâmetro ID " + personagemRequest.getAtorID() + ", favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }

        PersonagemAtor personagemAtor = new PersonagemAtor (atorPeloID,personagemRequest.getNomePersonagem(),
                personagemRequest.getDescricaoPersonagem(), personagemRequest.getAtuacao());

        personagemAtorRepository.save(personagemAtor);

        return personagemAtor;
    }

    public void deletarPersonagens (List<PersonagemAtor> personagemAtors) {
        for (PersonagemAtor personagemAtor : personagemAtors)
            personagemAtorRepository.delete(personagemAtor);
    }


}
