package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

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
        double mediaLista = somaLista / numeros.size();

        return mediaLista;
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
        List<Integer> numerosOrdenados = numeros;
        int auxiliar = 0;
        for (int i = 0; i < numerosOrdenados.size(); i++) {
            for (int j = 0; j < numerosOrdenados.size(); j++) {
                if (numerosOrdenados.get(i) < numerosOrdenados.get(j)) {
                    auxiliar = numerosOrdenados.get(j);
                    numerosOrdenados.set(j, numerosOrdenados.get(i));
                    numerosOrdenados.set(i, auxiliar);
                }
            }
        }
        return numerosOrdenados;
    }
}

