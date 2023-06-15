import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela_pedidos extends JFrame {
    // lista de pedidos

    Adicionar ad = new Adicionar();

    Remover re = new Remover();
    Finalizar fe = new Finalizar();


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
    JPanel painel_preco = new JPanel();

    JLabel preco = new JLabel();

    Tela_pedidos() {
        ArrayList<Produto> pedidos = ad.Deserializar();
        numero_de_produtos = pedidos.size();

        // n fazem nada por enquanto, apenas placeholder
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

        String header = String.format("|%2s|%-18s|%-6s|%-8s| ", "ID", "nome","quant.", "preco");
        header_lista.setFont(new Font("Courier new", Font.PLAIN, 15));
        header_lista.setText(header);

        // painel de produtos
        painel_produtos.setPreferredSize(new Dimension(400, 40 * numero_de_produtos));
        painel_produtos.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        painel_produtos.setOpaque(false);
//        painel_produtos.setBackground(Color.green); // cor pra debug

        painel_preco.setPreferredSize(new Dimension(400,50 ));
        painel_preco.setBackground(Color.green);
        painel_preco.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        painel_preco.setOpaque(false);


        preco.setFont(new Font("Courier new", Font.PLAIN, 15));
        String preco_valor = "Valor Total: " + Double.toString(fe.Valor_total_pedido());
        preco.setText(preco_valor);
        painel_preco.add(preco);



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
        for (Produto produto : pedidos) {
            // texto
            JLabel informacao_produto = new JLabel(produto.Informcao1());
            informacao_produto.setFont(new Font("Courier new", Font.PLAIN, 15));
            informacao_produto.setSize(200, 100);
            painel_produtos.add(informacao_produto);

            // botão
            adicionar_produto = new JButton("-");
            adicionar_produto.setFocusable(false); // tira uma borda que o texto do botão tem por padrão
            adicionar_produto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    re.Remover_PorID(produto.getID());
                    dispose();
                    new Tela_pedidos();
                }
            }); // faz o botão ser funcional
            painel_produtos.add(adicionar_produto);
        }

        this.add(painel_navegacao);
        this.add(painel_produtos);
        this.add(painel_preco);

        this.setLocationRelativeTo(null); // faz a janela aparecer no centro da tela
        this.setVisible(true); // exibe a janela
    }

}
