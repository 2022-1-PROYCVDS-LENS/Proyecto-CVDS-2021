package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.services.ExceptionRecursosBiblioteca;

import java.util.List;

public interface HorarioDAO {

    public void save(Horario horario);
    public List<Horario> load(int id) throws ExceptionRecursosBiblioteca;
}
