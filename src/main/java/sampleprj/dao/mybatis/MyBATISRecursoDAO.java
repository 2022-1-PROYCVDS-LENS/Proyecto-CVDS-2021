package sampleprj.dao.mybatis;

import com.google.inject.Inject;
import sampleprj.dao.RecursoDAO;
import sampleprj.dao.mybatis.mappers.RecursoMapper;
import samples.entities.Recurso;

import java.util.List;

public class MyBATISRecursoDAO implements RecursoDAO {
    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void save(Recurso recurso) {

    }

    @Override
    public Recurso load(int id) {
        return null;
    }

    @Override
    public List<Recurso> consultarRecursos() {
        return null;
    }
}
