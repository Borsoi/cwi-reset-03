public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item) {
        if ("pao".equals(item)) {
            //Pão estava nomeado como pães, realizei essa troca
            return ItensPorQuantidade.pao < 600;
        }

        if ("torta".equals(item)) {
            return ItensPorQuantidade.torta < 10;
        }
        // String sanduiche estava escrito como "sanduba", alterei para sanduiche
        if ("sanduiche".equals(item)) {
            return ItensPorQuantidade.sanduiche == 1;
        }

        if ("cafe".equals(item)) {
            return ItensPorQuantidade.leite < 12;
        }

        if ("leite".equals(item)) {
            return ItensPorQuantidade.cafe < 12;
        }

        return false;
    }
}
