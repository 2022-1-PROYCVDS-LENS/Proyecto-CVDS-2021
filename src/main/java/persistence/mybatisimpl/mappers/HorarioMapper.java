package persistence.mybatisimpl.mappers;

import entities.Horario;
import org.apache.ibatis.annotations.Param;
import services.ExceptionRecursosBiblioteca;

import java.sql.Time;
import java.util.List;

public interface HorarioMapper {
    List<Horario> consultarHorario(@Param("element") int id_recurso);
    void guardar(
            @Param("hora_ini") Time hora_ini,
            @Param("hora_fin") Time hora_fin
    );
}
