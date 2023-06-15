import java.io.Serializable;
import java.util.ArrayList;

public class listaSerial implements Serializable {
    public ArrayList<Usuario> usuarios;


    public listaSerial(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public ArrayList<Usuario> ReturnU(){
        ArrayList<Usuario> usu = new ArrayList<>();
        for(int u = 0;u<usuarios.size();u+=1){
        usu.add(usuarios.get(u));
    }
    return usu;}

}
