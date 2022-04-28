package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Usuario;
import org.apache.ibatis.exceptions.PersistenceException;
import persistence.UsuarioDAO;
import persistence.mybatisimpl.mappers.UsuarioMapper;

public class MyBATISUsuarioDAO implements UsuarioDAO {
    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public Usuario buscarUsuario(String correo) throws PersistenceException {
        try{
            return usuarioMapper.buscarUsuarioxCorreo(correo);
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
