package persistence;

import entities.Horario;

public interface HorarioDAO {

    public void save(Horario horario);
    public Horario load(int id);
}
