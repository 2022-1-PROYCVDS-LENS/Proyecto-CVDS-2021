package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Horario;
import persistence.HorarioDAO;
import persistence.mybatisimpl.mappers.HorarioMapper;

public class MyBATISHorarioDAO implements HorarioDAO {
    @Inject
    private HorarioMapper horarioMapper;

    @Override
    public void save(Horario horario) {

    }

    @Override
    public Horario load(int id) {
        return null;
    }
}
