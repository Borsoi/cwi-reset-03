package br.com.cwi.reset.projeto1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraServiceTest {

    @Mock
    private LeitorTeclado leitorTeclado;

    @InjectMocks
    private CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    public void testeMultiplicar() {
        //Arrange
        Double numero01 = 2.0;
        Double numero02 = 5.0;
        Double resultadoEsperado = 10.0;

        //Action
        Double resultado = calculadoraService.multiplicar(numero01, numero02);

        //Assert
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testeSomaComDoisNumerosInteirosPositivos() {
        //Arrange

        List<Integer> numeros = Arrays.asList(4, 9);
        int esperado = 13;

        //Action
        int resultado = calculadoraService.soma(numeros);

        //Assert
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void testeMultipilicarLendoInformacoesDoUsuario() {
        //Arrange
//      Mockito.doReturn(2,5).when(leitorTeclado.lerDouble());
        Mockito.when(leitorTeclado.lerDouble()).thenReturn(2.0, 5.0);
        Double esperado = 10.0;

        //Action
        Double resultado = calculadoraService.multiplicarUsandoOTeclado();

        //Assert
        Assert.assertEquals(esperado,resultado);
        Mockito.verify(leitorTeclado, Mockito.times(2)).lerDouble();
    }

}
