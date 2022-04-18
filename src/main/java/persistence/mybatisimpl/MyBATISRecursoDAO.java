package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Recurso;
import entities.TipoRecurso;
import persistence.RecursoDAO;
import persistence.mybatisimpl.mappers.RecursoMapper;


import java.util.List;

public class MyBATISRecursoDAO implements RecursoDAO {
    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void save(Recurso recurso) {
        recursoMapper.insertarRecurso(recurso);
    }

    @Override
    public Recurso load(int id) {
        return null;
    }

    @Override
    public List<Recurso> consultarRecursos() {
        return recursoMapper.consultarRecursos();
    }

    @Override
    public List<Recurso> consultarRecursosPorTipo(int tipo) {
        return recursoMapper.consultarRecursosPorTipo(tipo);
    }

    @Override
    public List<Recurso> consultarRecursosPorCapacidad(int i) {
        return recursoMapper.consultarRecursosPorCapacidad(i);
    }

    @Override
    public List<Recurso> consultarRecursosPorUbicacion(String ubi) {
        return recursoMapper.consultarRecursosPorUbicacion(ubi);
    }

    @Override
    public void registrarRecurso(String nombre, String ubicacion, TipoRecurso tipo, int capacidad) {
        recursoMapper.registrarRecurso(nombre, ubicacion, tipo, capacidad);
    }
}
