package br.com.cwi.reset.primeiroprojetospring.exceptions;

public class AvaliacaoForaDoPadraoException extends RuntimeException{

    public AvaliacaoForaDoPadraoException() {
        super("Erro, a avaliação deve estar entre 1 e 5");
    }
}

