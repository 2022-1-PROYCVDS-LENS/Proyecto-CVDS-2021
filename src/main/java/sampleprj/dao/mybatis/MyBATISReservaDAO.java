package sampleprj.dao.mybatis;

import com.google.inject.Inject;
import sampleprj.dao.ReservaDAO;
import sampleprj.dao.mybatis.mappers.ReservaMapper;
import samples.entities.Reserva;

public class MyBATISReservaDAO implements ReservaDAO {
    @Inject
    private ReservaMapper reservaMapper;

    @Override
    public void save(Reserva reserva) {

    }

    @Override
    public Reserva load(int id) {
        return null;
    }
}
