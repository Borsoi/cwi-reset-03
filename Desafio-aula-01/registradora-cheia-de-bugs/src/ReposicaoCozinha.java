public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("pao".equals(item)) {
            ItensPorQuantidade.pao += 3600;
        //Pão estava nomeado como pães, realizei essa troca
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta += 4;

        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche += 20;
        }
        //Adicionado a opção +=, pois somente trocava a variavel para valor que deveria ser adicionado
    }
}
