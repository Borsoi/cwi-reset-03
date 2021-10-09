public class Ator {

    private String nome;
    private Integer idade;
    private Integer numeroOscar;
    private Genero genero;

    public Ator(String nome, Integer idade, Integer numeroOscar, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.numeroOscar = numeroOscar;
        this.genero = genero;
    }

    public void dadosPessoais() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println ("Gênero: " + genero.getDescricao());
        System.out.println ("");
    }

}
