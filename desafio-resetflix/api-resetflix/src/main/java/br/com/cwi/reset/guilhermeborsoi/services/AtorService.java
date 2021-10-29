package br.com.cwi.reset.guilhermeborsoi.services;

import br.com.cwi.reset.guilhermeborsoi.domain.Ator;
import br.com.cwi.reset.guilhermeborsoi.domain.StatusCarreira;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.repository.AtorRepository;
import br.com.cwi.reset.guilhermeborsoi.repository.PersonagemAtorRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;
    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest) throws MensagemDeErro {

        Optional<Ator> atorExistente = atorRepository.findByNome(atorRequest.getNome());
        if (atorExistente.isPresent()) {
            String e = "Já existe um ator cadastrado para o nome " + atorRequest.getNome();
            throw new MensagemDeErro(e);
        }

        if (!atorRequest.getNome().contains(" ")) {
            String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
            throw new MensagemDeErro(e);
        }

        if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
            String e = "Ano de início de atividade inválido para o ator cadastrado";
            throw new MensagemDeErro(e);
        }

        Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(),
               atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        atorRepository.save(ator);

    }

    public List<Ator> listarAtoresEmAtividade (String filtroNome) throws MensagemDeErro {

        if (atorRepository.findAll().isEmpty()) {
            String e = "Nenhum ator cadastrado, favor cadastrar atores";
            throw new MensagemDeErro(e);
        }

        List<Ator> atoresEmAtividade;

        if (filtroNome.isEmpty()) {
            atoresEmAtividade = atorRepository.findByStatusCarreira(StatusCarreira.EM_ATIVIDADE);
        }

        else {
            atoresEmAtividade = atorRepository.findByNomeAndStatusCarreira(filtroNome, StatusCarreira.EM_ATIVIDADE);

            if (atoresEmAtividade.isEmpty()) {
                String e = "Ator não encontrato com o filtro " + filtroNome + ", favor informar outro filtro";
                throw new MensagemDeErro(e);
            }
        }

        return atoresEmAtividade;

    }

    public Ator consultarAtor (Integer id) throws MensagemDeErro {

        if ( id.equals(null)) {
            String e = ("Campo obrigatório não informado. Favor informar o campo ID" );
            throw new MensagemDeErro(e);
        }

        Optional<Ator> consultaAtor = atorRepository.findById(id);

        if (!consultaAtor.isPresent()) {
            String e = ("Nenhum ator encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados");
            throw new MensagemDeErro(e);
        }
        Ator atorExistente = consultaAtor.get();

        return atorExistente;

    }

    public List<Ator> consultarAtores () throws MensagemDeErro {
        if (atorRepository.findAll().isEmpty()) {
            String e = "Nenhum ator cadastrado, favor cadastar atores";
            throw new MensagemDeErro(e);
        }
        return atorRepository.findAll();
    }

    public void atualizar (Integer id, AtorRequest atorRequest) throws MensagemDeErro {

        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErro(e);
        }

        Optional<Ator> atorCadastradoPeloID = atorRepository.findById(id);
        if (!atorCadastradoPeloID.isPresent()) {
            String e = "Nenhum ator encontrado com o parâmetro id " + id + " favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }

        Ator atorCadastrado = atorCadastradoPeloID.get();

        Optional<Ator> atorCadastradoPeloNome = atorRepository.findByNome(atorRequest.getNome());

        if(atorCadastradoPeloNome.isPresent()) {
            if (!id.equals(atorCadastradoPeloNome.get().getId())) {
                String e = "Já existe um ator cadastrado para o nome " + atorRequest.getNome();
                throw new MensagemDeErro(e);
            }
        }

        atorCadastrado.setNome(atorRequest.getNome());
        atorCadastrado.setDataNascimento(atorRequest.getDataNascimento());
        atorCadastrado.setStatusCarreira(atorRequest.getStatusCarreira());
        atorCadastrado.setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());

        atorRepository.save(atorCadastrado);
    }

    public void deletar (Integer id) throws MensagemDeErro {

        if (id.equals(null)) {
            String e = "Campo obrigatório não informado. Favor informar o campo ID";
            throw new MensagemDeErro(e);
        }

        Optional<Ator> atorExistenteID = atorRepository.findById(id);

        if (!atorExistenteID.isPresent()) {
            String e = "Nenhum ator encontrado com o parâmetro id " + id + " favor verifique os parâmetros informados";
            throw new MensagemDeErro(e);
        }
        Ator atorExistente = atorExistenteID.get();

        if (!personagemAtorRepository.findByAtor(atorExistente).isEmpty()) {
            String e = "Este ator está vinculado a um ou mais personagens, para remover o ator é necessário remover os seus personagens de atuação";
            throw new MensagemDeErro(e);
        }

        atorRepository.delete(atorExistente);
    }

}