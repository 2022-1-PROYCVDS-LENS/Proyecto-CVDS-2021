package sampleprj.dao.mybatis;

import com.google.inject.Inject;
import sampleprj.dao.TipoRecursoDAO;
import sampleprj.dao.mybatis.mappers.TipoRecursoMapper;
import samples.entities.TipoRecurso;

public class MyBATISTipoRecursoDAO implements TipoRecursoDAO {
    @Inject
    private TipoRecursoMapper tipoRecursoMapper;

    @Override
    public void save(TipoRecurso tipoRecurso) {

    }

    @Override
    public TipoRecurso load(int id) {
        return null;
    }
}
