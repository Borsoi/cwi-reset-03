package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.FakeDatabase;
import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.domain.Estudio;
import br.com.cwi.reset.guilhermeborsoi.domain.Personagem;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.requests.PersonagemRequest;

public class PersonagemService {

    private FakeDatabase fakeDatabase;

    public PersonagemService (FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    //Demais Métodos

    public Personagem cadastrarPersonagem (PersonagemRequest personagemRequest) throws MensagemDeErro {
        Ator atorPeloID = null;
        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (personagemRequest.getAtorID() == ator.getId()){
                for (Personagem personagens : fakeDatabase.recuperaPersonagens()) {
                    if (personagemRequest.getNomePersonagem().equals(personagens.getNomePersonagem())){
                        String e = "Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme";
                        throw new MensagemDeErro(e);
                    }
                }
                atorPeloID = ator;
            }

        }
         if (atorPeloID == null) {
            String e = "Nenhum ator encontrado com o parâmetro ID " + personagemRequest.getAtorID() + ", favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }

        Personagem personagem = new Personagem(fakeDatabase.recuperaPersonagens().size(),atorPeloID,personagemRequest.getNomePersonagem(),
                personagemRequest.getDescricaoPersonagem(), personagemRequest.getAtuacao());

        fakeDatabase.persistePersonagem(personagem);
        return personagem;
    }
}
