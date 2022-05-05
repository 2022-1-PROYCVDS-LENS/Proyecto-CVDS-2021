package persistence;


import entities.Recurso;
import entities.Reserva;
import entities.Usuario;

import java.sql.Time;
import java.sql.Timestamp;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
    public void reservarRecurso(Usuario usuario, Recurso recurso, Timestamp inicio, Timestamp fin, boolean recurrente, String estado, String solicitud);
}
