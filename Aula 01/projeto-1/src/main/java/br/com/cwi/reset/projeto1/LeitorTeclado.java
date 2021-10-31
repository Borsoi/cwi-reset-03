package br.com.cwi.reset.projeto1;

import java.util.Scanner;

public class LeitorTeclado {

    public Double lerDouble() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro numero: ");
        return scanner.nextDouble();
    }
}
