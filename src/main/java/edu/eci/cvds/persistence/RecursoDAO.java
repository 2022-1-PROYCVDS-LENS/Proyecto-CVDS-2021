package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.services.ExceptionRecursosBiblioteca;

import java.util.List;

public interface RecursoDAO {
    public void save(Recurso recurso);
    public Recurso load(int id);

    public List<Recurso> consultarRecursos();

    public List<Recurso> consultarRecursosPorTipo(int tipo);

    public List<Recurso> consultarRecursosPorCapacidad(int i);

    public List<Recurso> consultarRecursosPorUbicacion(String ubi);

    List<Recurso> consultarRecursosPorTipoCapacidadUbicacion(int tipo, int capacidad, String ubicacion);

    List<Recurso> consultarRecursosPorTipoYCapacidad(int tipo, int capacidad);

    List<Recurso> consultarRecursosPorTipoYUbicacion(int tipo, String ubicacion);

    List<Recurso> consultarRecursosPorUbicacionYCapacidad(String ubicacion, int capacidad);

    void registrarRecurso(String nombre, String habilitado, String ubicacion, int ejemplar, TipoRecurso tipo, int capacidad) throws ExceptionRecursosBiblioteca;
}
