package persistence;


import entities.Reserva;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
}
