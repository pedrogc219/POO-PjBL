import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela_login extends JFrame implements ActionListener {
    // objetos necessarios para carregar usuarios e verificar dados
    Login login = new Login();
    ArrayList<Usuario> cadastrados = new ArrayList<>();
    PersistenciaUsuario persistencia = new PersistenciaUsuario();

    // receberão os valores dos inputs
    private String username;
    private String senha;

    private int LARGURA_TELA = 600;
    private int ALTURA_TELA = 600;

        // definindo os componentes da tela são configurados dentro do construtor
    // texto titulo
    JLabel texto_titulo = new JLabel("Restaurante");
    // texto login
    JLabel texto_login = new JLabel("Login");
    // texto ao lado dos inputs
    JLabel texto_username = new JLabel("Username");
    JLabel texto_senha = new JLabel("Senha");
    // inputs
    JTextField input_username = new JTextField();
    JPasswordField input_senha = new JPasswordField();
    // botões
    JButton button_login = new JButton("Login");
    JButton button_cadastrese = new JButton("Cadastre-se");
    // mensagem de erro
    JLabel mensagem_de_erro = new JLabel();
    // panel que contem os inputs + texto
    JPanel panel_inputs = new JPanel();

    Tela_login() {
        // extrai usuarios do .ser
        for (int i = 0; i < persistencia.carregarUsuarios().get(0).size(); i += 1) {
            cadastrados.add((persistencia.carregarUsuarios().get(0)).get(i));
        }

            // configurando componentes
        // titulo
        texto_titulo.setBounds(0, 0, LARGURA_TELA, 100);
        texto_titulo.setHorizontalAlignment(JLabel.CENTER);
        texto_titulo.setFont(new Font("Arial", Font.PLAIN, 40)); // muda estilo da fonte e tamanho

        // texto login
        texto_login.setBounds(0,100,LARGURA_TELA,50);
        texto_login.setHorizontalAlignment(JLabel.CENTER);
        texto_login.setFont(new Font("Arial", Font.PLAIN, 30));

        // container de inputs
        panel_inputs.setLayout(new GridLayout(2,2, 20, 10));
        panel_inputs.setBounds(130, 200, 300, 80);
        panel_inputs.setOpaque(false);
        // texto
        texto_username.setHorizontalAlignment(JLabel.RIGHT);
        texto_senha.setHorizontalAlignment(JLabel.RIGHT);

        // botões
        button_login.setBounds(240, 300, 120, 30);
        button_cadastrese.setBounds(240, 350, 120, 30);
        button_login.setFocusable(false); // tira uma borda que o texto do botão tem por padrão
        button_cadastrese.setFocusable(false); // tira uma borda que o texto do botão tem por padrão
        button_login.addActionListener(this); // faz o botão ser funcional
        button_cadastrese.addActionListener(this); // faz o botão ser funcional

        // mensagem de erro
        mensagem_de_erro.setBounds(0, 450, LARGURA_TELA, 50);
        mensagem_de_erro.setHorizontalAlignment(JLabel.CENTER);

        // frame
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // mata a aplicação ao fechar a janela, por padrão apenas esconde a janela e continua executando o programa
        this.setSize(LARGURA_TELA, ALTURA_TELA);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLayout(null);

        // adiciona componentes ao frame
        this.add(texto_titulo);
        this.add(texto_login);

        panel_inputs.add(texto_username);
        panel_inputs.add(input_username);
        panel_inputs.add(texto_senha);
        panel_inputs.add(input_senha);
        this.add(panel_inputs);

        this.add(button_login);
        this.add(button_cadastrese);
        this.add(mensagem_de_erro);

        this.setLocationRelativeTo(null); // faz a janela aparecer no centro da tela
        this.setVisible(true); // exibe a janela
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // botão login
        if (e.getSource()==button_login) {
            // pega os valores dos inputs
            username = input_username.getText();
            senha = String.valueOf(input_senha.getPassword());

            // verifica os dados
            if(login.verificarLogin(username, senha, cadastrados)){
//                mensagem_de_erro.setText("dados corretos");
                this.dispose();
                new Tela_produtos();
            } else {
                mensagem_de_erro.setText("dados invalidos");
                // limpa os inputs
                input_username.setText("");
                input_senha.setText("");
            }
        }

        // botão cadastre-se, muda de para tela de cadastro
        if (e.getSource()==button_cadastrese) {
            this.dispose(); // fecha essa tela
            new Tela_cadastro();
        }
    }
}