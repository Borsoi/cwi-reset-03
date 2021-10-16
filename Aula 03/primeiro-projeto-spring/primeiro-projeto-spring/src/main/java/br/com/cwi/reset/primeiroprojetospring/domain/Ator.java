package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

    public class Ator extends Pessoa {

        private Integer numeroOscar;

        public Ator(String nome, LocalDate dataDeNascimento, Integer numeroOscar, Genero genero) {
            super(nome, dataDeNascimento, genero);
            this.numeroOscar = numeroOscar;
        }
    }
