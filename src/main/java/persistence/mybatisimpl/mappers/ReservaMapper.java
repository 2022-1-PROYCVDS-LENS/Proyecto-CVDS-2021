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
    void reservarRecurso(@Param("id_usuario") int usuario,
                         @Param("id_recurso") int recurso,
                         @Param("inicio") Timestamp inicio,
                         @Param("fin") Timestamp fin,
                         @Param("recurrente") boolean recurrente,
                         @Param("estado") String estado,
                         @Param("h_ini") Time hIni,
                         @Param("h_fin") Time hFin,
                         @Param("solicitud") Timestamp solicitud );

    List<Reserva> consultarReservas();

    List<Reserva> consultarReservasActivas(@Param("id") int id);

    List<Reserva> consultarReservasCanceladas(@Param("id") int id);

    List<Reserva> consultarReservasPasadas(@Param("id") int id);

    void cancelarReserva(@Param("idReserva")int id);

    List<Reserva> consultarReservasPorUsuario(@Param("id") int id);

    Reserva consultarReservaExtendida(@Param("id") int id);
}
