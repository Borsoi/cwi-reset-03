import java.time.LocalDate;
import java.time.Period;

import static java.time.LocalDate.now;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataDeNascimento;
    private Genero genero;


    public String getNome() {
        return nome;
    }

    public Pessoa(String nome, LocalDate dataDeNascimento, Genero genero) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;

    }

    public void dadosPessoais() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + calcularIdade());
        System.out.println ("Gênero: " + genero.getDescricao());
        System.out.println ("");
    }

    public Integer calcularIdade () {
        Period periodo = Period.between(dataDeNascimento, LocalDate.now());
        Integer idade = periodo.getYears();
        return idade;
    }
}
