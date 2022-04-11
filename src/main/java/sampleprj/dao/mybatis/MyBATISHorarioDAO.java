package sampleprj.dao.mybatis;

import com.google.inject.Inject;
import sampleprj.dao.HorarioDAO;
import sampleprj.dao.mybatis.mappers.HorarioMapper;
import samples.entities.Horario;

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
