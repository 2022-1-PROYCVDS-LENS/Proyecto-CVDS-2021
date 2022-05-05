package persistence;


import entities.ReservaRecurrente;

public interface ReservaRecurrenteDAO {
    public void save(ReservaRecurrente reservaRecurrente);
    public ReservaRecurrente load(int id);
}
