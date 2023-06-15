import java.util.ArrayList;

public class Login {
    public static String nome;
    public boolean verificarLogin(String email, String senha, ArrayList<Usuario> listaUsuarios) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                nome = usuario.getEmail();
                return true;
            }
        }
        return false;
    }

    public boolean verificarCadastro(String email, ArrayList<Usuario> listaUsuarios) {

        for (Usuario usuario : listaUsuarios) {
            if (email.equals(usuario.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public static String get_Nome(){
        return nome;
    }

}
