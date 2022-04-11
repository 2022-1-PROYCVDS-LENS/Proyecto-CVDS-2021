package sampleprj.dao;


import samples.entities.Reserva;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
}
