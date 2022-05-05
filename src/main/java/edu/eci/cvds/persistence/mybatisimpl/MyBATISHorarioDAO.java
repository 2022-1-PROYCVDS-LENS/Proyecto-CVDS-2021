package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.services.ExceptionRecursosBiblioteca;
import edu.eci.cvds.persistence.mybatisimpl.mappers.HorarioMapper;

import java.util.List;

public class MyBATISHorarioDAO implements HorarioDAO {
    @Inject
    private HorarioMapper horarioMapper;

    List<Horario> horarios;

    @Override
    public void save(Horario horario) {

    }

    @Override
    public List<Horario> load(int id) throws ExceptionRecursosBiblioteca {
        horarios = horarioMapper.consultarHorario(id);
        if (horarios.size() == 0){
            throw new ExceptionRecursosBiblioteca("error");
        }
        return horarios;
    }
}
