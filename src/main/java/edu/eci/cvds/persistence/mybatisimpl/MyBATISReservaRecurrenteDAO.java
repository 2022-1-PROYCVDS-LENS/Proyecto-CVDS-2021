package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.ReservaRecurrente;
import edu.eci.cvds.persistence.ReservaRecurrenteDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaRecurrenteMapper;

public class MyBATISReservaRecurrenteDAO implements ReservaRecurrenteDAO {
    @Inject
    private ReservaRecurrenteMapper reservaRecurrenteMapper;


    @Override
    public void save(ReservaRecurrente reservaRecurrente) {

    }

    @Override
    public ReservaRecurrente load(int id) {
        return null;
    }
}
