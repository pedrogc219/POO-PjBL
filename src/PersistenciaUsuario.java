import java.io.*;
import java.util.ArrayList;

public class PersistenciaUsuario {
    public void salvarUsuarios(listaSerial wrapper) {
        try {
            FileOutputStream fileOut = new FileOutputStream("usuario.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(wrapper);

            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ArrayList<Usuario>> carregarUsuarios() {
        ArrayList<ArrayList<Usuario>> listaU = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("usuario.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            listaSerial u = (listaSerial) in.readObject();
            listaU.add(u.ReturnU());

            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaU;
    }
}

