public abstract class Pessoa {

    private String nome;
    private Integer idade;
    private Genero genero;

    public String getNome() {
        return nome;
    }

    public Pessoa(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public void dadosPessoais() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println ("Gênero: " + genero.getDescricao());
        System.out.println ("");
    }

}
