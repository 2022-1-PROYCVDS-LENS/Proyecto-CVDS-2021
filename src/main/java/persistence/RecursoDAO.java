package persistence;

import entities.Recurso;
import entities.TipoRecurso;

import java.util.List;

public interface RecursoDAO {
    public void save(Recurso recurso);
    public Recurso load(int id);

    public List<Recurso> consultarRecursos();

    public List<Recurso> consultarRecursosPorTipo(int tipo);

    public List<Recurso> consultarRecursosPorCapacidad(int i);

    public List<Recurso> consultarRecursosPorUbicacion(String ubi);

    public void registrarRecurso(String nombre, String ubicacion, TipoRecurso tipo, int capacidad);
}
