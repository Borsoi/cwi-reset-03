
public class Registradora {

    public static void main(String[] args) {
        primeiroBug();

        segundoBug();

        terceiroBug();

        quartoBug();

        quintoBug();

        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = 0;
        if (!QuantidadeMinimaItem.verificaEstoque(item, quantidade)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (DataProjeto.cozinhaEmFuncionamento()) {
                    ReposicaoCozinha.reporItem(item);
                }
            }
            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }
        if (QuantidadeMinimaItem.verificaEstoque(item, quantidade)) {
            precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            RetiradaEstoque.retirarEstoque(item, quantidade);
        }
        else {
            System.out.println ("Quantidade insuficiente em estoque de " + item);
            System.out.print("Quantidade solicitado " + quantidade + ", quantidade restante em estoque: ");

            switch (item) {
                case "pao":
                    System.out.println(ItensPorQuantidade.pao);
                    break;
                case "sanduiche":
                    System.out.println(ItensPorQuantidade.sanduiche);
                    break;
                case "torta":
                    System.out.println(ItensPorQuantidade.torta);
                    break;
                case "cafe":
                    System.out.println(ItensPorQuantidade.cafe);
                    break;
                case "leite":
                    System.out.println(ItensPorQuantidade.leite);
            }
        }

        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Cozinha fechada!");

                    System.out.println ("A reposição do item " + item + " não está disponível");
                    System.out.print("Quantidade restante em estoque: ");

                    switch (item) {
                        case "pao":
                            System.out.println(ItensPorQuantidade.pao);
                            break;
                        case "sanduiche":
                            System.out.println(ItensPorQuantidade.sanduiche);
                            break;
                        case "torta":
                            System.out.println(ItensPorQuantidade.torta);
                            break;
                    }

                    //Adicionar o aviso de reposição indisponível + quantidade de estoque restante
                }
                else
                    ReposicaoCozinha.reporItem(item);
            }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }

        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}
