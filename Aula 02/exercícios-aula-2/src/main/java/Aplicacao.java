public class Aplicacao {

    public static void main(String[] args) {

        Diretor diretor01 = new Diretor ("Guilherme Borsoi", 24, 2, Genero.MASCULINO);
        Ator ator01 = new Ator("Claudiscleide", 35, 0, Genero.FEMININO);

        Filme filme01 = new Filme("Buggando a Mente", "A história conta como um aluno do RESET enloqueceu durante os exercícios",
                160, "2021", 0, diretor01);

        Filme filme02 = new Filme("O Jovem Sobrevivente", "A história conta a sequência de buggando a mente, mostrando como o jovem sobrevivou ao curso do RESET",
                190, "2022", 0, diretor01);

        filme01.reproduzir();
        filme02.reproduzir();

        diretor01.dadosPessoais();
        ator01.dadosPessoais();
    }
}
