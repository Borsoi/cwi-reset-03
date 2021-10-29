package br.com.cwi.reset.guilhermeborsoi.services;


import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErroException;
import br.com.cwi.reset.guilhermeborsoi.repository.DiretorRepository;
import br.com.cwi.reset.guilhermeborsoi.repository.FilmeRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws MensagemDeErroException {

        Optional<Diretor> diretorCadatrado = diretorRepository.findByNome(diretorRequest.getNome());
        if (diretorCadatrado.isPresent()){
            String e = "Já existe um diretor cadastrado para o nome " + diretorRequest.getNome();
            throw new MensagemDeErroException(e);
        }

        if (!diretorRequest.getNome().contains(" ")) {
            String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
            throw new MensagemDeErroException(e);

        } else if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()) {
            String e = "Ano de início de atividade inválido para o ator cadastrado";
            throw new MensagemDeErroException(e);
        }

        Diretor diretor = new Diretor(diretorRequest.getNome(),
            diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        diretorRepository.save(diretor);
    }


    public List listarDiretores (String filtroNome) throws MensagemDeErroException {

        if (diretorRepository.findAll().isEmpty()) {
            String e = "Nenhum diretor cadastrado, favor cadastrar diretores";
            throw new MensagemDeErroException(e);
        }

        List<Diretor> diretoresContendoNome = diretorRepository.findByNomeContains(filtroNome);

        if (diretoresContendoNome.isEmpty()) {
            String e = "Diretor não encontrato com o filtro" + filtroNome + ", favor informar outro filtro";
            throw new MensagemDeErroException(e);
        }

        return diretoresContendoNome;
    }

//        List <Diretor> diretores = new ArrayList<>();
//        for (Diretor diretor : diretorRepository.findAll()) {
//            if (filtroNome.equals("") || filtroNome == null) {
//                diretores.add(diretor);
//            } else if (diretor.getNome().contains(filtroNome)) {
//                    diretores.add(diretor);
//            }
//            else {
//
//            }
//        }
//        return diretores;
//    }

    public Diretor consultarDiretor (Integer id) throws MensagemDeErroException {

        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErroException(e);
        }

        Optional<Diretor> diretorExistente = diretorRepository.findById(id);

        if (!diretorExistente.isPresent()) {
            String e = "Nenhum diretor encontrado com o parâmetro ID " + id + ", favor verifique os parâmetros informados.";
            throw new MensagemDeErroException(e);
        }

        return diretorExistente.get();


    }
//        if (id.equals(null)) {
//            String e = "Campo obrigatório não informado. Favor informar o campo ID";
//            throw new MensagemDeErroException(e);
//        }
//        for (Diretor diretor : diretorRepository.findAll()) {
//            if (id == diretor.getId()) {
//                return diretor;
//            }
//        }
//        String e = "Nenhum diretor encontrado com o parâmetro ID " + id + ", favor verifique os parâmetros informados.";
//        throw new MensagemDeErroException(e);
//    }

    public void atualizarDiretor (Integer id, DiretorRequest diretorRequest) throws MensagemDeErroException {

        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErroException(e);
        }

        Optional<Diretor> diretorExistenteID = diretorRepository.findById(id);
        if (!diretorExistenteID.isPresent()) {
            String e = "Nenhum ator encontrado com o parâmetro id " + id + " favor verifique os parâmetros informados";
            throw new MensagemDeErroException(e);
        }

        Diretor diretorExiste = diretorExistenteID.get();

        Optional<Diretor> diretorPeloNome = diretorRepository.findByNome(diretorRequest.getNome());

        if (diretorPeloNome.isPresent()) {
            if (id.equals(diretorExiste.getId())) {
                String e = "Já existe um ator cadastrado para o nome " + diretorRequest.getNome();
                throw new MensagemDeErroException(e);
            }
        }

        diretorExiste.setNome(diretorRequest.getNome());
        diretorExiste.setDataNascimento(diretorRequest.getDataNascimento());
        diretorExiste.setAnoInicioAtividade(diretorRequest.getAnoInicioAtividade());

        diretorRepository.save(diretorExiste);
    }

    public void removerDiretores (Integer id) throws MensagemDeErroException {
        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErroException(e);
        }

        Optional<Diretor> diretorExistenteID = diretorRepository.findById(id);
        if (!diretorExistenteID.isPresent()) {
            String e = "Nenhum ator encontrado com o parâmetro id " + id + " favor verifique os parâmetros informados";
            throw new MensagemDeErroException(e);
        }
        Diretor diretorExistente = diretorExistenteID.get();

        if (!filmeRepository.findByDiretor(diretorExistente).isEmpty()) {
            String e = "Este diretor está vinculado a um ou mais filmes, para remover o diretor é necessário remover os seus filmes de participação";
            throw new MensagemDeErroException(e);
        }
        diretorRepository.delete(diretorExistente);
    }
}

