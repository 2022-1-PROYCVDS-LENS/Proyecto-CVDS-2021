package persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;
import entities.Usuario;

public interface UsuarioMapper {

    public Usuario buscarUsuarioxCorreo(@Param ("Correo") String correo);

    public Usuario consultarUsuarioPorId(@Param("id") int id);

}
