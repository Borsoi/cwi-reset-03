import java.time.LocalDate;

public class Diretor extends Pessoa {

    private Integer quantFilmesDirigidos;

    public Diretor(String nome, LocalDate dataDeNascimento, Integer quantFilmesDirigidos, Genero genero) {
        super(nome, dataDeNascimento, genero);
        this.quantFilmesDirigidos = quantFilmesDirigidos;
    }
}
