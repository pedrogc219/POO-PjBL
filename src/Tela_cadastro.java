import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela_cadastro extends JFrame implements ActionListener {
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
    JLabel texto_titulo = new JLabel("Restaurante x");
    // texto registre-se
    JLabel texto_registrese = new JLabel("Registre-se");
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

    Tela_cadastro() {
        // extrai usuarios do .ser
        for (int i = 0; i < persistencia.carregarUsuarios().get(0).size(); i += 1) {
            cadastrados.add((persistencia.carregarUsuarios().get(0)).get(i));
        }

            // configurando componentes
        // titulo
        texto_titulo.setBounds(0, 0, LARGURA_TELA, 100);
        texto_titulo.setHorizontalAlignment(JLabel.CENTER);
        texto_titulo.setFont(new Font("Arial", Font.PLAIN, 40)); // muda estilo da fonte e tamanho

        // texto registre-se
        texto_registrese.setBounds(0,100,LARGURA_TELA,50);
        texto_registrese.setHorizontalAlignment(JLabel.CENTER);
        texto_registrese.setFont(new Font("Arial", Font.PLAIN, 30));

        // container de inputs
        panel_inputs.setLayout(new GridLayout(2,2, 20, 10));
        panel_inputs.setBounds(130, 200, 300, 80);
        panel_inputs.setOpaque(false);
        // texto
        texto_username.setHorizontalAlignment(JLabel.RIGHT);
        texto_senha.setHorizontalAlignment(JLabel.RIGHT);

        // botões
        button_login.setBounds(240, 350, 120, 30);
        button_cadastrese.setBounds(240, 300, 120, 30);
        button_login.setFocusable(false); // tira uma borda que o texto do botão tem por padrão
        button_cadastrese.setFocusable(false); // tira uma borda que o texto do botão tem por padrão
        button_login.addActionListener(this); // faz o botão ser funcional
        button_cadastrese.addActionListener(this); // faz o botão ser funcional

        // mensagem de erro
        mensagem_de_erro.setBounds(0, 450, LARGURA_TELA, 50);
        mensagem_de_erro.setHorizontalAlignment(JLabel.CENTER);

        // frame
        this.setTitle("Cadastro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // mata a aplicação ao fechar a janela, por padrão apenas esconde a janela e continua executando o programa
        this.setSize(LARGURA_TELA, ALTURA_TELA);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLayout(null);

        // adiciona componentes ao frame
        this.add(texto_titulo);
        this.add(texto_registrese);

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
        if (e.getSource()==button_cadastrese) {
            // pega os valores dos inputs
            username = input_username.getText();
            senha = String.valueOf(input_senha.getPassword());
            // limpa os inputs
            input_username.setText("");
            input_senha.setText("");

            if (!username.isEmpty() && !senha.isEmpty()) {
                if(login.verificarCadastro(username,cadastrados)){
                    Usuario usuario = new Usuario(username,senha);
                    cadastrados.add(usuario);
                    listaSerial listaS = new listaSerial(cadastrados);
                    persistencia.salvarUsuarios(listaS);
                    cadastrados.clear();
                    mensagem_de_erro.setText("Registado com sucesso");
                    dispose();
                    new Tela_login();

                } else {
                    mensagem_de_erro.setText("Usuario já existente, tente novamente");
                }
            } else {
                mensagem_de_erro.setText("Preencha todos os campos");
            }
        }

        if (e.getSource()==button_login) {
            this.dispose();
            new Tela_login();
        }
    }
}