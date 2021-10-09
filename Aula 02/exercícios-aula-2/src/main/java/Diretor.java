public class Diretor {

    private String nome;
    private Integer idade;
    private Integer quantFilmesDirigidos;

    public String getNome() {
        return nome;
    }

    public Diretor(String nome, Integer idade, Integer quantFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.quantFilmesDirigidos = quantFilmesDirigidos;
    }
}
