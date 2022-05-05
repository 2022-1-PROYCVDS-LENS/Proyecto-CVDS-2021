package edu.eci.cvds.persistence;


import edu.eci.cvds.entities.Reserva;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
}
