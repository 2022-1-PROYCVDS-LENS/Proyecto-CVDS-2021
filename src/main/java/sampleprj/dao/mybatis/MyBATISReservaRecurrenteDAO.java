package sampleprj.dao.mybatis;

import com.google.inject.Inject;
import sampleprj.dao.ReservaRecurrenteDAO;
import sampleprj.dao.mybatis.mappers.ReservaRecurrenteMapper;
import samples.entities.ReservaRecurrente;

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
