package sampleprj.dao;

import samples.entities.Horario;

public interface HorarioDAO {

    public void save(Horario horario);
    public Horario load(int id);
}
