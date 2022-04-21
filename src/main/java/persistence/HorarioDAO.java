package persistence;

import entities.Horario;

import java.util.List;

public interface HorarioDAO {

    public void save(Horario horario);
    public List<Horario> load(int id);
}
