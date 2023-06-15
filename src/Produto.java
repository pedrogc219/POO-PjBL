import java.io.Serializable;

public abstract class Produto implements Serializable {
    private String descricao;
    protected int ID;
    private String nome;
    protected int Quantidade;

    protected int quantidade;
    protected double valor;

    public Produto(String descricao,int ID, String nome, double valor, int Quantidade){
        this.descricao = descricao;
        this.ID = ID;
        this.nome = nome;
        this.valor = valor;
        this.Quantidade = Quantidade;
    }

    public String descricao(){return descricao;}

    public String nome(){return nome;}

    public int getID(){return ID;}

    public Double valor_desconto(){
        return desconto();
    }

    public String Informcao(){
        String info = String.format("|%2s|%-20s|%-8s|", ID, nome,"R$ "+valor);
        System.out.println(info);
        return info;
    }

    public String Informcao1(){
        String info = String.format("|%2s|%-18s|%-6s|%-8s|", ID, nome,Quantidade,"R$ "+valor);
        System.out.println(info);
        return info;
    }



    public Double valor_final(){
        return valor_desconto() * Quantidade;
    }

    public void incrementarQuantidade() {
        Quantidade++;
    }

    protected abstract Double desconto();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Produto produto = (Produto) obj;
        return nome.equals(produto.nome);
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void decrementarQuantidade() {
        Quantidade--;
    }


}
