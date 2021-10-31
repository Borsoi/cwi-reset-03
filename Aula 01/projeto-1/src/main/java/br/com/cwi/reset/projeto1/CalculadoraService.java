package br.com.cwi.reset.projeto1;

import java.util.List;

public class CalculadoraService {

    private LeitorTeclado leitorTeclado = new LeitorTeclado();

    public CalculadoraService() {
    }

    public double multiplicar (Double numero1, Double numero2) {
        return (Double) (numero1 * numero2);
    }

    public int soma (List<Integer> numeros) {
        int resultado = 0;
        for (int numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }

    public Double multiplicarUsandoOTeclado() {
        Double numeroUm = leitorTeclado.lerDouble();
        Double numeroDois = leitorTeclado.lerDouble();;

        return multiplicar(numeroUm, numeroDois);
    }
}
