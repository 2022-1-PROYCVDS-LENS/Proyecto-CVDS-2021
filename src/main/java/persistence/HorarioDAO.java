package persistence;

import entities.Horario;
import services.ExceptionRecursosBiblioteca;

import java.util.List;

public interface HorarioDAO {

    public void save(Horario horario);
    public List<Horario> load(int id) throws ExceptionRecursosBiblioteca;
}
