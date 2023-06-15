import java.io.Serializable;

public class Usuario implements Serializable {
    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "[" + email + "," + senha + "]";
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
