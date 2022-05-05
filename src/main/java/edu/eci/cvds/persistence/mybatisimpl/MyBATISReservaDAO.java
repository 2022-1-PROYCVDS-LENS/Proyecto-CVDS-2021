package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;

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
