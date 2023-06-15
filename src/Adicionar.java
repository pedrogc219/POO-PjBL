import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Adicionar {

    public static void Pedir(ArrayList<Produto> produtos, int ID, ArrayList<Produto> pedidos ) throws IOException {
        for (Object produto : produtos) {
            if (produto instanceof Produto) { // Verifica se o objeto é uma instância de ClasseConcreta
                Produto pedido = (Produto) produto;
                if (ID == pedido.getID()) { // Verifica se o ID é igual ao desejado
                    if (pedidos.contains(pedido)) {
                        int index = pedidos.indexOf(pedido);
                        Produto produtoExistente = pedidos.get(index);
                        produtoExistente.incrementarQuantidade();
                    } else {
                        pedidos.add(pedido);
                    }
                }
            }
        }

        Serializar(pedidos);
    }

    // produtos
    public static ArrayList<Produto> Inicializar(){
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new HotDog("Quentinho", 1, "Hot Dog Quente", 4.6, 1));
        produtos.add(new HotDog("Friozinho", 2, "Hot Dog Frio", 5.0, 1));
        produtos.add(new PratoFeito("Arroz, Feijao, Bife", 3, "Prato Feito do Dia", 15.00, 1));
        produtos.add(new Sobremesa("Maracuja",4,"Mousse", 5.00, 1));
        produtos.add(new Suco("Uva ou Laranja", 5, "Suco Natural", 5.0, 1));

        return produtos;
    }

    // salvar & abrir pedido
    public static void Serializar(ArrayList<Produto> pedidos) {
        try {
            FileOutputStream fileOut = new FileOutputStream("colecao.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(pedidos);

            objectOut.close();
            fileOut.close();
            System.out.println("Coleção de objetos foi salva com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Produto> Deserializar() {
        try {
            FileInputStream fileIn = new FileInputStream("colecao.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Produto> colecaoRecuperada = (ArrayList<Produto>) objectIn.readObject();

            objectIn.close();
            fileIn.close();

            return colecaoRecuperada;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


