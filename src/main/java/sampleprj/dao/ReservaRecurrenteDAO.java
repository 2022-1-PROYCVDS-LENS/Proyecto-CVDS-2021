package sampleprj.dao;


import samples.entities.ReservaRecurrente;

public interface ReservaRecurrenteDAO {
    public void save(ReservaRecurrente reservaRecurrente);
    public ReservaRecurrente load(int id);
}
