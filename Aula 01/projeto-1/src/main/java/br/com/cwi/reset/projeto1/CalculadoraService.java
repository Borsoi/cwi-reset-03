package br.com.cwi.reset.projeto1;

import java.util.List;

public class CalculadoraService {

    public CalculadoraService() {
    }

    public double multiplicar (double numero1, double numero2) {
        return (double) (numero1 * numero2);
    }

    public int soma (List<Integer> numeros) {
        int resultado = 0;
        for (int numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }

    public void divisao (double numero1, double numero2) {

    }
}
