import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // lista de usuarios
        ArrayList<Usuario> cadastrados = new ArrayList<>();
        Login login = new Login();
        PersistenciaUsuario persistencia = new PersistenciaUsuario();

        for(int i =0; i<persistencia.carregarUsuarios().get(0).size(); i+=1){
                cadastrados.add((persistencia.carregarUsuarios().get(0)).get(i));
        }
//        System.out.println(cadastrados);//serve para ver o que tem de login

        new Tela_login();

        // BAGULHO NO TERMINAL
        /*
        Scanner scanner = new Scanner(System.in);
        boolean passar = true;
        while(passar = true){
            //login
//            System.out.println(persistencia.carregarUsuarios());//tirar esse print

            System.out.print("Digite seu usuario:");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha:");
            String senha = scanner.nextLine();
            if(login.verificarLogin(email,senha,cadastrados)){
                System.out.println("confirmado, pode prosseguir ");
                break;//colocar a saida para o resto do codigo aqui
            }
            //cadastro
            else{
                System.out.println("usuario incorreto ou inexistente ");
                System.out.println("vamos fazer seu cadastro: email e senha ");
                String emailC = scanner.nextLine();
                String senhaC = scanner.nextLine();
                if(login.verificarCadastro(emailC,cadastrados)){
                    Usuario usuario = new Usuario(emailC,senhaC);
                    cadastrados.add(usuario);
                    listaSerial listaS = new listaSerial(cadastrados);
                    persistencia.salvarUsuarios(listaS);
                    System.out.println(persistencia.carregarUsuarios());
                    cadastrados.clear();
                }
                else {
                    System.out.println("usuario já existente,tente novamente ");
                }
            }

        }


        // aqui fica a parte do pedido
        ArrayList<Produto> pedidos = new ArrayList<>();
        boolean pedindo = true;
        while (pedindo) {
            System.out.println("Enter ID");
            int id_desejado = scanner.nextInt();

            for (Object obj : produtos) {
                if (obj instanceof Produto) { // Verifica se o objeto é uma instância de ClasseConcreta
                    Produto pedido = (Produto) obj;
                    if (id_desejado == pedido.getID()) { // Verifica se o ID é igual ao desejado
                        pedidos.add(pedido);
                    }
                }
            }
            System.out.println("Digite 1 para fechar");
            int aa = scanner.nextInt();
            if(aa == 1) {
                pedindo = false;
            }
            else {
                pedindo = true;
            }
        }

        Adicionar ad = new Adicionar();
        Remover re = new Remover();
        Finalizar fe = new Finalizar();

        ad.Serializar(pedidos);
        ad.Deserializar();
        // re.Remover_PorID(2);
        //ad.Deserializar();
        fe.Finalizar_Pedido();
        fe.Imprimir_Recibo("Fernando");
        */
    }
}