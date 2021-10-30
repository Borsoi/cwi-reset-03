package br.com.cwi.reset.projeto1;

import java.util.List;

public class Exercicios1 {

    public Exercicios1() {
    }

    public Integer somarLista(List<Integer> numeros) {
        int somaLista = 0;
        for (int i = 0; i < numeros.size(); i++) {
            somaLista = somaLista + numeros.get(i);
        }

        return somaLista;
    }

    public Double calcularMedia(List<Integer> numeros) {
        int somaLista = 0;
        for (int i = 0; i < numeros.size(); i++) {
            somaLista = somaLista + numeros.get(i);
        }
        if (somaLista == 0) {
            return 0.0;
        }

        return (double) (somaLista / (double) numeros.size());
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        int maiorNumero = 0;
        for (int i = 0; i < numeros.size(); i++) {
            if (maiorNumero < numeros.get(i)) {
                maiorNumero = numeros.get(i);
            }
        }
        return maiorNumero;
    }

    public String obterPalavraInvertida(String palavra) {
        String palavraInvertida = "";
        for (int i = palavra.length()-1; i >= 0; i--) {
            palavraInvertida += palavra.charAt(i);
        }
        return palavraInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        int auxiliar = 0;
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = 0; j < numeros.size(); j++) {
                if (numeros.get(i) < numeros.get(j)) {
                    auxiliar = numeros.get(j);
                    numeros.set(j, numeros.get(i));
                    numeros.set(i, auxiliar);
                }
            }
        }
        return numeros;
    }
}

