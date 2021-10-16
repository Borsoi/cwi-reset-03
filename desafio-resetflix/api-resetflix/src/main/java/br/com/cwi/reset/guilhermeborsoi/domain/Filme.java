package br.com.cwi.reset.guilhermeborsoi.domain;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Filme {

    private Integer id;
    private String nome;
    private LocalDate anoLancamento;
    private ImageIcon capaFilme;
    private Genero genero;
    private Diretor diretor;
    private Estudio estudio;
    private List<PersonagemAtor> personagens;
    private String resumo;

}
