package persistence;


import entities.Reserva;

import java.util.List;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
    public List<Reserva> consultarReservas();
}
