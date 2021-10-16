package br.com.cwi.reset.guilhermeborsoi;

import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplicacao {

    public static void main(String[] args) throws MensagemDeErro {
        SpringApplication.run(Aplicacao.class, args);

    }
}

