import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;;

public class Remover {
    public static void Remover_PorID(int id){
        Adicionar ad = new Adicionar();
        ArrayList<Produto> pedidos = ad.Deserializar();

        for (Produto obj : pedidos) {
            if (obj.getID() == id) {
                // Verifica se a quantidade é maior que 1
                if (obj.getQuantidade() > 1) {
                    obj.decrementarQuantidade();
                } else {
                    pedidos.remove(obj); // Remove o objeto da ArrayList
                }
                break; // Sai do loop após encontrar o objeto
            }
        }
        ad.Serializar(pedidos);
    }

    public static void Remover_Pedido(){
        Adicionar ad = new Adicionar();
        ArrayList<Produto> pedidos = ad.Deserializar();
        pedidos.clear();
        ad.Serializar(pedidos);
    }
}
