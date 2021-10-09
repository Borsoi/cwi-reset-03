public class Diretor {

    private  String nome;
    private int idade;
    private int quantFilmesDirigidos;

    public String getNome() {
        return nome;
    }

    public Diretor(String nome, int idade, int quantFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.quantFilmesDirigidos = quantFilmesDirigidos;
    }
}
