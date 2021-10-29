package br.com.cwi.reset.guilhermeborsoi;

import br.com.cwi.reset.guilhermeborsoi.exceptions.MensagemDeErroException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplicacao {

    public static void main(String[] args) throws MensagemDeErroException {
        SpringApplication.run(Aplicacao.class, args);

    }
}

