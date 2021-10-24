package br.com.cwi.reset.guilhermeborsoi.services;


import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.repository.DiretorRepository;
import br.com.cwi.reset.guilhermeborsoi.repository.FilmeRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws MensagemDeErro {

        for (Diretor diretores : diretorRepository.findAll()) {
            if (diretores.getNome().equals(diretorRequest.getNome())) {
                String e = "Já existe um diretor cadastrado para o nome " + diretorRequest.getNome();
                throw new MensagemDeErro(e);
            }
        } if (!diretorRequest.getNome().contains(" ")) {
            String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
            throw new MensagemDeErro(e);

        } else if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()) {
            String e = "Ano de início de atividade inválido para o ator cadastrado";
            throw new MensagemDeErro(e);
        }

        Diretor diretor = new Diretor(diretorRequest.getNome(),
            diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        diretorRepository.save(diretor);
    }


    public List listarDiretores (String filtroNome) throws MensagemDeErro {
        if (diretorRepository.count() == 0) {
            String e = "Nenhum diretor cadastrado, favor cadastrar diretores";
            throw new MensagemDeErro(e);
        }
        List <Diretor> diretores = new ArrayList<>();
        for (Diretor diretor : diretorRepository.findAll()) {
            if (filtroNome.equals("") || filtroNome == null) {
                diretores.add(diretor);
            } else if (diretor.getNome().contains(filtroNome)) {
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
        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErro(e);
        }
        for (Diretor diretor : diretorRepository.findAll()) {
            if (id == diretor.getId()) {
                return diretor;
            }
        }
        String e = "Nenhum diretor encontrado com o parâmetro ID " + id + ", favor verifique os parâmetros informados.";
        throw new MensagemDeErro(e);
    }

    public void atualizarDiretor (Integer id, DiretorRequest diretorRequest) throws MensagemDeErro {
        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErro(e);
        }

        Optional<Diretor> diretorExistenteID = diretorRepository.findById(id);
        if (!diretorExistenteID.isPresent()) {
            String e = "Nenhum ator encontrado com o parâmetro id " + id + " favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }

        Diretor diretorAtualizado = new Diretor(diretorRequest.getNome(),
                diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        diretorAtualizado.setId(diretorExistenteID.get().getId());

        for (Diretor diretor : diretorRepository.findAll()) {
            if (diretor.getNome().equals(diretorRequest.getNome())) {
                if (diretor.getId().equals(diretorAtualizado.getId())) {
                    String e = "Já existe um ator cadastrado para o nome " + diretor.getNome();
                    throw new MensagemDeErro(e);
                }
            }
        }
        diretorRepository.save(diretorAtualizado);
    }

    public void removerDiretores (Integer id) throws MensagemDeErro {
        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErro(e);
        }

        Optional<Diretor> diretorExistenteID = diretorRepository.findById(id);
        if (!diretorExistenteID.isPresent()) {
            String e = "Nenhum ator encontrado com o parâmetro id " + id + " favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }
        Diretor diretorExistente = diretorExistenteID.get();

        if (!filmeRepository.findByDiretor(diretorExistente).isEmpty()) {
            String e = "Este diretor está vinculado a um ou mais filmes, para remover o diretor é necessário remover os seus filmes de participação";
            throw new MensagemDeErro(e);
        }
        diretorRepository.delete(diretorExistente);
    }
}

