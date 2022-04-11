package sampleprj.dao;

import samples.entities.Horario;
import samples.entities.Recurso;

import java.util.List;

public interface RecursoDAO {
    public void save(Recurso recurso);
    public Recurso load(int id);

    public List<Recurso> consultarRecursos();
}
