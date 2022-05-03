package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Recurso;
import entities.TipoRecurso;
import persistence.RecursoDAO;
import persistence.mybatisimpl.mappers.RecursoMapper;
import services.ExceptionRecursosBiblioteca;


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
    public List<Recurso> consultarRecursosPorTipoCapacidadUbicacion(int tipo, int capacidad, String ubicacion) {
        return recursoMapper.consultarRecursosTipoCapaUbi(tipo,capacidad,ubicacion);
    }

    @Override
    public List<Recurso> consultarRecursosPorTipoYCapacidad(int tipo, int capacidad) {
        return recursoMapper.consultarRecursosTipoCapa(tipo,capacidad);
    }

    @Override
    public List<Recurso> consultarRecursosPorTipoYUbicacion(int tipo, String ubicacion) {
        return recursoMapper.consultarRecursosTipoUbi(tipo,ubicacion);
    }

    @Override
    public List<Recurso> consultarRecursosPorUbicacionYCapacidad(String ubicacion, int capacidad) {
        return recursoMapper.consultarRecursosCapaUbi(capacidad, ubicacion);
    }

    @Override
    public void registrarRecurso(String nombre, String habilitado, String ubicacion, int ejemplar, TipoRecurso tipo, int capacidad) throws ExceptionRecursosBiblioteca{
        try{
            recursoMapper.registrarRecurso(nombre, habilitado, ubicacion, ejemplar, tipo, capacidad);
        }catch (Exception e){
            throw new ExceptionRecursosBiblioteca("error");
        }

    }



}
