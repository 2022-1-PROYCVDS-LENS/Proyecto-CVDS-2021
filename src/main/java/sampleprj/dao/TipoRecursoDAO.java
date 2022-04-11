package sampleprj.dao;


import samples.entities.TipoRecurso;

public interface TipoRecursoDAO {
    public void save(TipoRecurso tipoRecurso);
    public TipoRecurso load(int id);
}
