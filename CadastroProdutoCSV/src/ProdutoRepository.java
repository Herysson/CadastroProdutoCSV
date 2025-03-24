import java.io.*;
import java.util.*;

public class ProdutoRepository {
    private static final String FILE_NAME = "produtos.csv";

    public void salvar(Produto produto) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String linha = produto.getNome() + "," + produto.getPreco() + "," + produto.getQuantidade();
            writer.write(linha);
            writer.newLine();
        }
    }

    public List<Produto> carregarTodos() throws IOException {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                Produto produto = new Produto(campos[0], Double.parseDouble(campos[1]), Integer.parseInt(campos[2]));
                produtos.add(produto);
            }
        }
        return produtos;
    }
}
