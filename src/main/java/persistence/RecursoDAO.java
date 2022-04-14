package persistence;

import entities.Recurso;

import java.util.List;

public interface RecursoDAO {
    public void save(Recurso recurso);
    public Recurso load(int id);

    public List<Recurso> consultarRecursos();
}
