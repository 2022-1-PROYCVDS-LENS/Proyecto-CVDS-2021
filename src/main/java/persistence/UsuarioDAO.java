package persistence;


import entities.Usuario;
import org.apache.ibatis.exceptions.PersistenceException;

public interface UsuarioDAO {
    public Usuario buscarUsuario(String correo) throws PersistenceException;

    Usuario load(int id);

    void save(Usuario u);
}
