import java.io.Serializable;

public class Suco extends Produto implements Serializable {

    public Suco(String descricao, int ID, String nome, double valor, int quantidade){
        super(descricao, ID, nome, valor, quantidade);
    }

    protected Double desconto(){
        if (super.Quantidade >= 3){
            return valor * 0.9;
        }
        else{
            return valor;
        }
    }
}