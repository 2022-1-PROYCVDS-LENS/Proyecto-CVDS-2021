package persistence;

import entities.Horario;
import services.ExceptionRecursosBiblioteca;

import java.sql.Time;
import java.util.List;

public interface HorarioDAO {

    public void save(Horario horario);
    public List<Horario> load(int id) throws ExceptionRecursosBiblioteca;
    void guardar(Time hora_ini, Time hora_fin);
}
