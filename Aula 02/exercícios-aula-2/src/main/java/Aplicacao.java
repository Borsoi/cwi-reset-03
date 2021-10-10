import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        Diretor diretor01 = new Diretor("Guilherme Borsoi", LocalDate.of(1997, 4, 20), 2, Genero.MASCULINO);
        Ator ator01 = new Ator("Claudiscleide", LocalDate.of(1985, 9, 15), 0, Genero.FEMININO);

        List<Filme> listaDeFilme = new ArrayList<>();

        try {
            Filme filme01 = new Filme("Buggando a Mente", "A história conta como um aluno do RESET enloqueceu durante os exercícios",
                    160, "2021", 0, diretor01);

            listaDeFilme.add(filme01);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Filme filme02 = new Filme("O Jovem Sobrevivente", "A história conta a sequência de buggando a mente, mostrando como o jovem sobrevivou ao curso do RESET",
                    190, "2022", 3.0, diretor01);

            listaDeFilme.add(filme02);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Filme filme03 = new Filme("A Ascensão do Jovem", "A história segue a sequência do jovem que tenta crescer dentro da área da programação",
                    170, "2023", 4.0, diretor01);

            listaDeFilme.add(filme03);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Filme filme04 = new Filme("O Futuro Promissor", "A história demonstra os resultados do esforço do jovem na sua carreira, 5 anos após o último filme",
                    120, "2028", 5.0, diretor01);

            listaDeFilme.add(filme04);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < listaDeFilme.size(); i++) {
            listaDeFilme.get(i).reproduzir();
        }

        diretor01.dadosPessoais();
        ator01.dadosPessoais();

    }
}

