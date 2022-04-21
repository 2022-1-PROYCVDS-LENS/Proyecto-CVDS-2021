package persistence.mybatisimpl.mappers;

import entities.Horario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HorarioMapper {
    List<Horario> consultarHorario(@Param("element") int id_recurso);
}
