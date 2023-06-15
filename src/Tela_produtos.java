import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Tela_produtos extends JFrame {
    // lista de produtos
    Adicionar ad = new Adicionar();

    ArrayList<Produto> produtos = new ArrayList<>();
    ArrayList<Produto> pedidos = ad.Deserializar();

    Usuario usuario;

    private int LARGURA_TELA = 600;
    private int ALTURA_TELA = 600;
    private int numero_de_produtos;

    // n fazem nada por enquanto, apenas placeholder
    JButton tela1 = new JButton("Produtos");
    JButton tela2 = new JButton("Pedidos");
    JButton tela3 = new JButton("Finalizar");

    JLabel header_lista = new JLabel();
    JButton adicionar_produto;

    JPanel painel_navegacao = new JPanel();
    JPanel painel_produtos = new JPanel();

    Tela_produtos() {
        produtos = ad.Inicializar();
        numero_de_produtos = produtos.size();

        tela1.setFocusable(false); // tira uma borda que o texto do botão tem por padrão
        tela1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // fecha essa tela
                new Tela_produtos();
            }
        });

        tela2.setFocusable(false);
        tela2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Tela_pedidos();
            }
        });

        tela3.setFocusable(false);
        tela3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Tela_Finalizar();
            }
        });

        // painel de navegacao
        painel_navegacao.setPreferredSize(new Dimension(LARGURA_TELA, 50));
        painel_navegacao.setOpaque(false);
//        painel_navegacao.setBackground(Color.blue); // cor pra debug

        String header = String.format("|%2s|%-20s|%-8s| ", "ID", "nome", "preco");
        header_lista.setFont(new Font("Courier new", Font.PLAIN, 15));
        header_lista.setText(header);

        // painel de produtos
        painel_produtos.setPreferredSize(new Dimension(400, 40 * numero_de_produtos));
        painel_produtos.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        painel_produtos.setOpaque(false);
//        painel_produtos.setBackground(Color.green); // cor pra debug

        // frame
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // mata a aplicação ao fechar a janela, por padrão apenas esconde a janela e continua executando o programa
        this.setSize(LARGURA_TELA, ALTURA_TELA);
        this.getContentPane().setBackground(Color.lightGray);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setResizable(false);

        // adicinando componentes
        painel_navegacao.add(tela1);
        painel_navegacao.add(tela2);
        painel_navegacao.add(tela3);

        // cria a lista de produtos
        painel_produtos.add(header_lista);
        // cria as linhas com informações + botão
        for (Produto produto : produtos) {
            // texto
            JLabel informacao_produto = new JLabel(produto.Informcao());
            informacao_produto.setFont(new Font("Courier new", Font.PLAIN, 15));
            informacao_produto.setSize(200, 100);
            painel_produtos.add(informacao_produto);

            // botão
            adicionar_produto = new JButton("+");
            adicionar_produto.setFocusable(false); // tira uma borda que o texto do botão tem por padrão
            adicionar_produto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ad.Pedir(produtos, produto.getID(), pedidos);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }); // faz o botão ser funcional
            painel_produtos.add(adicionar_produto);
        }

        this.add(painel_navegacao);
        this.add(painel_produtos);

        this.setLocationRelativeTo(null); // faz a janela aparecer no centro da tela
        this.setVisible(true); // exibe a janela
    }

}
