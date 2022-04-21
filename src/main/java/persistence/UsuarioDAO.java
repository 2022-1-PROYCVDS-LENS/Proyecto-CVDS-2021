package persistence;


import entities.Usuario;

public interface UsuarioDAO {
    public void save(Usuario usuario);
    public Usuario load(int id);
}
