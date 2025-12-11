import java.util.Collections;
import java.util.List;

class UserModel {

    private int idUser;
    private String descricao;

    public static final int IDADE_MINIMA = 18;

    // Obtém todos os usuários
    public List<UserModel> fetchUsers() {
        return Collections.emptyList();
    }

    // Obtém todos os usuários (evite duplicar métodos com mesmo propósito)
    public List<UserModel> getAllUsers() {
        return Collections.emptyList();
    }

    // Obtém todos os usuários (a depender do caso, você deve manter só 1 dos 3 métodos)
    public List<UserModel> getUsers() {
        return Collections.emptyList();
    }
}