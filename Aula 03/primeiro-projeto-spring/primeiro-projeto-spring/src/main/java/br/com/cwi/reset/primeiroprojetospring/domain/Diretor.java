package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

    public class Diretor extends Pessoa {

        private Integer quantFilmesDirigidos;

        public Integer getQuantFilmesDirigidos() {
            return quantFilmesDirigidos;
        }

        public Diretor(String nome, LocalDate dataDeNascimento, Integer quantFilmesDirigidos, Genero genero) {
            super(nome, dataDeNascimento, genero);
            this.quantFilmesDirigidos = quantFilmesDirigidos;
        }
    }
