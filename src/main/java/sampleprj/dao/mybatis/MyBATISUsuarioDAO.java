package sampleprj.dao.mybatis;

import com.google.inject.Inject;
import sampleprj.dao.UsuarioDAO;
import sampleprj.dao.mybatis.mappers.UsuarioMapper;
import samples.entities.Usuario;

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
