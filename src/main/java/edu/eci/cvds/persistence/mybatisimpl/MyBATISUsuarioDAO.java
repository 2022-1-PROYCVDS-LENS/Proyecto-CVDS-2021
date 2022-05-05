package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.UsuarioDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

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

    @Override
    public Usuario load(int id) {
        return null;
    }

    @Override
    public void save(Usuario u) {

    }
}
