package br.com.cwi.reset.projeto1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Exercicios1Test {

    @Test
    public void deveSomarCincoNumerosInteirosEPositivos() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5,9,3,4,1);
        Integer somaEsperado = 22;

        //Action
        Integer somaResultado = calculadora.somarLista(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveSomarQuatroNumerosInteirosEUmNegativo() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5,9,3,-4,1);
        Integer somaEsperado = 14;

        //Action
        Integer somaResultado = calculadora.somarLista(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveSomarTresNumerosNegativos() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(-5,-9,-1);
        Integer somaEsperado = -15;

        //Action
        Integer somaResultado = calculadora.somarLista(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveSomarNumerosZerados() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(0,0,0,0,0);
        Integer somaEsperado = 0;

        //Action
        Integer somaResultado = calculadora.somarLista(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveSomarListaVazia() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList();
        Integer somaEsperado = 0;

        //Action
        Integer somaResultado = calculadora.somarLista(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveFazerMediaDeCincoNumerosInteirosPositivos() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5,9,3,4,1);
        Double somaEsperado = 4.4;

        //Action
        Double somaResultado = calculadora.calcularMedia(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveFazerMediaDeQuatroNumerosPositivosEUmNegativo() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5,9,3,-4,1);
        Double somaEsperado = 2.8;

        //Action
        Double somaResultado = calculadora.calcularMedia(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveFazerMediaDeTresNumerosNegativos() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(-5, -9, -1);
        Double somaEsperado = -5.0;

        //Action
        Double somaResultado = calculadora.calcularMedia(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveFazerMediaDeNumerosZerados() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList(0,0,0,0,0);
        Double somaEsperado = 0.0;

        //Action
        Double somaResultado = calculadora.calcularMedia(numeros);

        //Assert
        Assert.assertEquals(somaEsperado, somaResultado);
    }

    @Test
    public void deveFazerMediaDeListaVazia() {
        //Arrange
        Exercicios1 calculadora = new Exercicios1();
        List<Integer> numeros = Arrays.asList();
        Double esperado = 0.0;

        //Action
        Double somaResultado = calculadora.calcularMedia(numeros);

        //Assert
        Assert.assertEquals(esperado, somaResultado);
    }

    @Test
    public void deveInverterAPalavraAbacate() {
        //Arrange
        Exercicios1 inversorDePalavras = new Exercicios1();
        String esperado = "etacabA";

        //Action
        String resultado = inversorDePalavras.obterPalavraInvertida("Abacate");

        Assert.assertEquals(esperado,resultado);
    }

    @Test
    public void deveInverterAPalavraBanana() {
        //Arrange
        Exercicios1 inversorDePalavras = new Exercicios1();
        String esperado = "ananaB";

        //Action
        String resultado = inversorDePalavras.obterPalavraInvertida("Banana");

        Assert.assertEquals(esperado,resultado);
    }

    @Test
    public void deveInverterAPalavraPessego() {
        //Arrange
        Exercicios1 inversorDePalavras = new Exercicios1();
        String esperado = "ogesseP";

        //Action
        String resultado = inversorDePalavras.obterPalavraInvertida("Pessego");

        Assert.assertEquals(esperado,resultado);
    }

    @Test
    public void deveInverterAPalavraMorango() {
        //Arrange
        Exercicios1 inversorDePalavras = new Exercicios1();
        String esperado = "ognaroM";

        //Action
        String resultado = inversorDePalavras.obterPalavraInvertida("Morango");

        Assert.assertEquals(esperado,resultado);
    }


}
