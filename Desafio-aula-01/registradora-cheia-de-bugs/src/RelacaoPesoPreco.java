public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int quantidade) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (quantidade * 60.0) / 1000.0;
        }

        if ("torta".equals(item)) {
            precoTotal = 96.00 * (quantidade / 16.0);
            // 16 estava como inteiro, devolvendo valor inteiro de 0
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * quantidade;
        }

        if ("cafe".equals(item)) {
            precoTotal = 9.56 * quantidade;
            // Café estava com acento
        }

        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * quantidade;
            // String sanduiche estava escrito como "sanduba", alterei para sanduiche
        }

        return precoTotal;
    }
}
