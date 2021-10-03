public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int quantidade) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (quantidade * 60 / 1000);
        }

        if ("torta".equals(item)) {
            precoTotal = 96.00 * (quantidade / 16);
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * quantidade;
        }

        if ("café".equals(item)) {
            precoTotal = 9.56 * quantidade;
        }
        // String sanduiche estava escrito como "sanduba", alterei para sanduiche
        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * quantidade;
        }

        return precoTotal;
    }
}
