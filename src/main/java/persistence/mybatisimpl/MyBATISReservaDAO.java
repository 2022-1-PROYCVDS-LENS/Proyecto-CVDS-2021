package persistence.mybatisimpl;

import com.google.inject.Inject;
import entities.Recurso;
import entities.Reserva;
import entities.Usuario;
import persistence.ReservaDAO;
import persistence.mybatisimpl.mappers.ReservaMapper;

import java.sql.Time;
import java.sql.Timestamp;
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
    public void reservarRecurso(Usuario usuario, Recurso recurso, Timestamp inicio, Timestamp fin, boolean recurrente, String estado, String solicitud) {
        reservaMapper.reservarRecurso(usuario,recurso,inicio,fin,recurrente,estado,solicitud );
    }

    @Override
    public List<Reserva> consultarReservas(){
        return reservaMapper.consultarReservas();
    }
}
