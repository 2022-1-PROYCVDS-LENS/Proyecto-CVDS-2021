package edu.eci.cvds.persistence;


import edu.eci.cvds.entities.TipoRecurso;

public interface TipoRecursoDAO {
    public void save(TipoRecurso tipoRecurso);
    public TipoRecurso load(int id);
}
