package sampleprj.dao.mybatis.mappers;

import samples.entities.Recurso;

import java.util.List;

public interface RecursoMapper {

    public void insertarRecurso(Recurso recurso);

    public List<Recurso> consultarRecursos();

}
