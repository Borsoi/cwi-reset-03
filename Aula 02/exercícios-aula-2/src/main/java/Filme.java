public class Filme {

    private String nome;
    private String descricao;
    private double duracao;
    private String anoLancamento;
    private double avaliacao;
    private Diretor diretor;

    public String getDescricao() {
        return descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public Filme(String nome, String descricao, double duracao, String anoLancamento, double avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir () {
        System.out.println("Nome do filme: " + this.nome);
        System.out.println ("Descrição: " + this.descricao);
        System.out.println (this.duracao + " minutos de duração");
        System.out.println("Com a direção de " + this.diretor.getNome());
        System.out.println ("");
    }

}
