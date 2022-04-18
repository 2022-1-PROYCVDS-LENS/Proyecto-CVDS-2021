package persistence.mybatisimpl.mappers;

import entities.Recurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecursoMapper {

    public void insertarRecurso(Recurso recurso);

    /**
     * Consultar los recursos disponibles en la plataforma
     * @return lista de los recursos en la plataforma
     */
    public List<Recurso> consultarRecursos();

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
