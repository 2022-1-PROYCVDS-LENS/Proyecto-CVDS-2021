package persistence.mybatisimpl.mappers;

import entities.Recurso;
import entities.Reserva;
import entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.sql.Time;
import java.util.List;
import java.sql.Timestamp;
import java.util.List;

public interface ReservaMapper {

    /**
     * Metodo para reservar un recurso especifico
     * @param usuario id del usuario que realizo la reserva
     * @param recurso id del recurso a reservar
     * @param inicio inicio de la reserva
     * @param fin fin de la reserva
     * @param recurrente indica si la reserva es recurrente
     * @param estado estado de la reserva
     * @param solicitud fecha que se realizo la solicitud de resevra
     */
    void reservarRecurso(@Param("usuario") Usuario usuario,
                         @Param("recurso") Recurso recurso,
                         @Param("inicio") Timestamp inicio,
                         @Param("fin") Timestamp fin,
                         @Param("recurrente") boolean recurrente,
                         @Param("estado") String estado,
                         @Param("solicitud") String solicitud );

    List<Reserva> consultarReservas();

    List<Reserva> consultarReservasActivas(@Param("id") int id);

    List<Reserva> consultarReservasCanceladas(@Param("id") int id);

    List<Reserva> consultarReservasPasadas(@Param("id") int id);

    List<Reserva> consultarReservasPorUsuario(@Param("id") int id);
}
