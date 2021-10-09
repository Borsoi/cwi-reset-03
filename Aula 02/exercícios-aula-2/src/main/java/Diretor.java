public class Diretor extends Pessoa {

    private Integer quantFilmesDirigidos;

    public Diretor(String nome, Integer idade, Integer quantFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.quantFilmesDirigidos = quantFilmesDirigidos;
    }
}
