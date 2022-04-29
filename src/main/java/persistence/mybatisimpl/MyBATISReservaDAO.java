package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Reserva;
import persistence.ReservaDAO;
import persistence.mybatisimpl.mappers.ReservaMapper;

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
    public void reservarRecurso(int id_usuario, int id_recurso, String inicio, String fin, boolean recurrente, String estado, String solicitud) {
        reservaMapper.reservarRecurso(id_usuario,id_recurso,inicio,fin,recurrente,estado,solicitud );
    }
}
