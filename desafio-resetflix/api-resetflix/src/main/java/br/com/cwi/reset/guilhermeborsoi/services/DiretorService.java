package br.com.cwi.reset.guilhermeborsoi.services;


import br.com.cwi.reset.guilhermeborsoi.domain.Diretor;
import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import br.com.cwi.reset.guilhermeborsoi.repository.DiretorRepository;
import br.com.cwi.reset.guilhermeborsoi.requests.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

//    private FakeDatabase fakeDatabase;
//
//    public DiretorService(FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;

    // Demais métodos da classe

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws MensagemDeErro {

        for (Diretor diretores : diretorRepository.findAll()) {
            if (diretores.getNome().equals(diretorRequest.getNome())) {
                String e = "Já existe um diretor cadastrado para o nome " + diretorRequest.getNome();
                throw new MensagemDeErro(e);
            }
        } if (!diretorRequest.getNome().contains(" ")) {
            String e = "Deve ser informado no mínimo nome e sobrenome para o ator";
            throw new MensagemDeErro(e);
//        } else if (diretorRequest.getDataNascimento().getYear() > LocalDate.now().getYear()) {
//            String e = "Não é possível cadastrar atores não nascidos";
//            throw new MensagemDeErro(e);
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
        if (id == null) {
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

}

