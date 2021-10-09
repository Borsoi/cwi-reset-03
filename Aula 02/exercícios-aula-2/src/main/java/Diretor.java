public class Diretor {

    private String nome;
    private Integer idade;
    private Integer quantFilmesDirigidos;
    private Genero genero;

    public String getNome() {
        return nome;
    }

    public Diretor(String nome, Integer idade, Integer quantFilmesDirigidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantFilmesDirigidos = quantFilmesDirigidos;
        this.genero = genero;
    }

    public void dadosPessoais() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println ("Gênero: " + genero.getDescricao());
        System.out.println ("");
    }
}
