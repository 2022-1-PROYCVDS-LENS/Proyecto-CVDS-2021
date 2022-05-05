package edu.eci.cvds.persistence;


import edu.eci.cvds.entities.ReservaRecurrente;

public interface ReservaRecurrenteDAO {
    public void save(ReservaRecurrente reservaRecurrente);
    public ReservaRecurrente load(int id);
}
