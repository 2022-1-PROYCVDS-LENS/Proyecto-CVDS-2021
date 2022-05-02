package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Reserva;
import persistence.ReservaDAO;
import persistence.mybatisimpl.mappers.ReservaMapper;

import java.util.List;

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

    @Override
    public List<Reserva> consultarReservas(){
        return reservaMapper.consultarReservas();
    }
}
