package br.com.cwi.reset.guilhermeborsoi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MensagemDeErroException extends Exception {
    public MensagemDeErroException(String e) {
        super (e);
    }

}
