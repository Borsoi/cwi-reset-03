public class Aplicacao {

    public static void main(String[] args) {

        Diretor diretor01 = new Diretor("Guilherme", 24, 2);

        Filme filme01 = new Filme("Buggando a Mente", "A história conta como um aluno do RESET enloqueceu durante os exercícios",
                160, "2021", 0, diretor01);

        Filme filme02 = new Filme("O Jovem Sobrevivente", "A história conta a sequência de buggando a mente, mostrando como o jovem sobrevivou ao curso do RESET",
                190, "2022", 0, diretor01);

        filme01.reproduzirFilme();
        filme02.reproduzirFilme();
    }
}
