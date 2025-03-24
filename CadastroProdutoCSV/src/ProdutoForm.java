import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ProdutoForm extends JFrame {
    private JTextField nomeField, precoField, quantidadeField;
    private JButton cadastrarButton;
    private ProdutoRepository repository = new ProdutoRepository();

    public ProdutoForm() {
        setTitle("Cadastro de Produto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 10, 160, 25);
        add(nomeField);

        JLabel precoLabel = new JLabel("Preço:");
        precoLabel.setBounds(10, 40, 80, 25);
        add(precoLabel);

        precoField = new JTextField();
        precoField.setBounds(100, 40, 160, 25);
        add(precoField);

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        quantidadeLabel.setBounds(10, 70, 80, 25);
        add(quantidadeLabel);

        quantidadeField = new JTextField();
        quantidadeField.setBounds(100, 70, 160, 25);
        add(quantidadeField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(100, 110, 100, 25);
        add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    double preco = Double.parseDouble(precoField.getText());
                    int quantidade = Integer.parseInt(quantidadeField.getText());

                    Produto produto = new Produto(nome, preco, quantidade);
                    repository.salvar(produto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    limparCampos();
                } catch (IOException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    private void limparCampos() {
        nomeField.setText("");
        precoField.setText("");
        quantidadeField.setText("");
    }

    public static void main(String[] args) {
        new ProdutoForm();
    }
}
