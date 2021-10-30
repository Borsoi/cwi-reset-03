package br.com.cwi.reset.projeto1;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class CalculadoraServiceTest {

    @Test
    public void testeMultiplicar() {
        //Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double numero01 = 2.0;
        double numero02 = 5.0;
        double resultadoEsperado = 10;

        //Action
        double resultado = calculadoraService.multiplicar(numero01, numero02);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    public void testeSomaComDoisNumerosInteirosPositivos() {
        //Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        List<Integer> numeros = Arrays.asList(4, 9);
        int esperado = 13;

        //Action
        int resultado = calculadoraService.soma(numeros);

        //Assert
        Assert.assertEquals(esperado, resultado);
    }


}
