import java.io.Serializable;

public class Sobremesa extends Produto implements Serializable {

    public Sobremesa(String descricao, int ID, String nome, double valor, int quantidade){
        super(descricao, ID, nome, valor, quantidade);
    }

    protected Double desconto(){
        if (super.Quantidade >= 2){
            return valor * 0.8;
        }
        else{
            return valor;
        }
    }
}