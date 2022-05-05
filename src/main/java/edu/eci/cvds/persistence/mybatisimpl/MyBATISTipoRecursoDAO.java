package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.persistence.TipoRecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.TipoRecursoMapper;

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
