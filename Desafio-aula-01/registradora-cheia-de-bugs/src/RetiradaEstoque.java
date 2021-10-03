public class RetiradaEstoque {

    public static void retirarEstoque (String item, int quantidade) {
        if ("pao".equals(item)) {
            ItensPorQuantidade.pao -= quantidade;
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta -= quantidade / 16.0;
        }
        if ("cafe".equals(item)) {
            ItensPorQuantidade.cafe -= quantidade;
        }
        if ("leite".equals(item)) {
            ItensPorQuantidade.leite -= quantidade;
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche -= quantidade;
        }
    }
}
