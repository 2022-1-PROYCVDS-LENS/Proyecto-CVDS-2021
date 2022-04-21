package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Usuario;
import persistence.UsuarioDAO;
import persistence.mybatisimpl.mappers.UsuarioMapper;

public class MyBATISUsuarioDAO implements UsuarioDAO {
    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public void save(Usuario usuario) {

    }

    @Override
    public Usuario load(int id) {
        return null;
    }
}
