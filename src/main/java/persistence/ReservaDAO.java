package persistence;


import entities.Recurso;
import entities.Reserva;
import entities.Usuario;

import java.sql.Time;
import java.util.List;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
    public void reservarRecurso(Usuario usuario, Recurso recurso, Time inicio, Time fin, boolean recurrente, String estado, String solicitud);

    List<Reserva> consultarReservasActivas(int id);

    List<Reserva> consultarReservasCanceladas(int id);

    List<Reserva> consultarReservasPasadas(int id);
}
