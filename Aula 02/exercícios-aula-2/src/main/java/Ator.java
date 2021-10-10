import java.time.LocalDate;
import java.time.Period;

public class Ator extends Pessoa {

    private Integer numeroOscar;

    public Ator(String nome, LocalDate dataDeNascimento, Integer numeroOscar, Genero genero) {
        super(nome, dataDeNascimento, genero);
        this.numeroOscar = numeroOscar;

    }
}
