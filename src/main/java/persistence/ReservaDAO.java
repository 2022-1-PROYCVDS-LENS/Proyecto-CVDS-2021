package persistence;


import entities.Recurso;
import entities.Reserva;
import entities.Usuario;
import org.bouncycastle.util.Times;

import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.List;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
    public void reservarRecurso(int usuario, int recurso, Timestamp inicio, Timestamp fin, boolean recurrente, String estado,Time hIni,Time hFin, Timestamp solicitud);

    public List<Reserva> consultarReservas();

    List<Reserva> consultarReservasActivas(int id);

    List<Reserva> consultarReservasCanceladas(int id);

    List<Reserva> consultarReservasPasadas(int id);

    List<Reserva> consultarReservasPorUsuario(int id);
}
