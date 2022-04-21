package persistence.mybatisimpl.mappers;

import entities.Recurso;
import entities.TipoRecurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecursoMapper {

    public void insertarRecurso(Recurso recurso);

    /**
     * Registrar un nuevo recurso
     * @param nombre el nombre del nuevo recurso
     * @param ubicacion la ubicación del nuevo recurso
     * @param tipo el tipo del nuevo recurso
     * @param capacidad la capacidad del nuevo recurso
     */
     void registrarRecurso(@Param("name") String nombre,
                           @Param("location") String ubicacion,
                           @Param("type") TipoRecurso tipo,
                           @Param("capacity") int capacidad);

    /**
     * Consultar los recursos disponibles en la plataforma
     * @return lista de los recursos en la plataforma
     */
    List<Recurso> consultarRecursos();

    /**
     * Consultar los recursos con cierto tipo
     * @param tipo tipo de los recursos que queremos listar
     * @return lista de los recursos con el tipo especificado
     */
    List<Recurso> consultarRecursosPorTipo(@Param("tipo") int tipo);

    /**
     * Consultar los recursos con cierta capacidad
     * @param i capacidad de los recursos que queremos listar
     * @return lista de los recursos con la capacidad especificada
     */
    List<Recurso> consultarRecursosPorCapacidad(@Param("cap") int i);

    List<Recurso> consultarRecursosPorUbicacion(@Param("ubi")String ubi);

}
