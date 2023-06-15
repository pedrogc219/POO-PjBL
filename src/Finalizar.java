import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Finalizar {
    public static Double Valor_total_pedido(){
        Adicionar ad = new Adicionar();
        ArrayList<Produto> pedidos = ad.Deserializar();
        double valor_total = 0.00;

        for (Produto objeto : pedidos){
            valor_total = valor_total + objeto.valor_final();
        }

        return valor_total;
    }

    public static void Imprimir_Recibo(String Nome){
        String fileName = "recibo"+Nome+".txt"; // Nome do arquivo de texto

        Adicionar ad = new Adicionar();
        ArrayList<Produto> pedidos = ad.Deserializar();

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for( Produto objeto : pedidos){
                bufferedWriter.write(objeto.nome());
                bufferedWriter.newLine();
                bufferedWriter.write("Valor: " + objeto.valor_desconto());
                bufferedWriter.newLine();
                bufferedWriter.write("Quantidade: " + objeto.Quantidade);
                bufferedWriter.newLine();
                bufferedWriter.write("Valor Total: " + objeto.valor_final());
                bufferedWriter.newLine();
                bufferedWriter.write("-----------------------------------");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Valor total a pagar: "+ Valor_total_pedido());
            bufferedWriter.close(); // Fechar o BufferedWriter

            System.out.println("Texto escrito com sucesso no arquivo.");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}

