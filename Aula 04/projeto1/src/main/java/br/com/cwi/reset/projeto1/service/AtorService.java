package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorJaExistenteException;
import br.com.cwi.reset.projeto1.exception.AtorNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtorService {

    private AtorRepository atorRepository;

    public Ator cadastrar (Ator ator) throws AtorJaExistenteException {
        Ator atorExistente = atorRepository.findByNome(ator.getNome());

        if (atorExistente != null) {
            throw new AtorJaExistenteException("O ator " + ator.getNome() + " já está cadastrado");
        }
        return atorRepository.save(ator);
    }

    public Ator buscarPeloNome (String nome) throws AtorNaoExistenteException {
        Ator atorExistente = atorRepository.findByNome(nome);

        if (atorExistente == null) {
            throw new AtorNaoExistenteException("O ator " + nome + " não foi encontrado");
        }
        return atorRepository.findByNome(nome);
    }

    public List<Ator> findByNumeroOscars (Integer numeroOscars) throws AtorNaoExistenteException {
       List<Ator> ator = atorRepository.findByNumeroOscars(numeroOscars);

        if (ator == null) {
            throw new AtorNaoExistenteException("Nenhum ator encontrado com o numero " + numeroOscars + " informados de oscars");
        }
        return ator;
    }

    public void deletar (String nome) throws AtorNaoExistenteException {
        Ator ator = atorRepository.findByNome(nome);

        if (ator == null) {
            throw new AtorNaoExistenteException("O ator " + nome + " não foi encontrado");
        }
        atorRepository.delete(ator);
    }

    public List<Ator> buscarPorFiltro (Integer oscars, Integer nascimento) {
        List<Ator> ator = atorRepository.findByNumeroOscars(oscars);
        LocalDate dataDeNascimento = LocalDate.of(nascimento, 1,1);

        return atorRepository.findByNumeroOscarsGreaterThanAndDataNascimentoGreaterThan(oscars, dataDeNascimento);
    }

}
