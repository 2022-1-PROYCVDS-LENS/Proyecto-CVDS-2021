package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Recurso;
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
}
