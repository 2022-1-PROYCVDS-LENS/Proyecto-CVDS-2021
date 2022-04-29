package persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

public interface ReservaMapper {

    /**
     * Metodo para reservar un recurso especifico
     * @param idUsuario id del usuario que realizo la reserva
     * @param idRecurso id del recurso a reservar
     * @param inicio inicio de la reserva
     * @param fin fin de la reserva
     * @param recurrente indica si la reserva es recurrente
     * @param estado estado de la reserva
     * @param solicitud fecha que se realizo la solicitud de resevra
     */
    void reservarRecurso(@Param("id_usuario") int idUsuario,
                         @Param("id_recurso") int idRecurso,
                         @Param("inicio") String inicio,
                         @Param("fin") String fin,
                         @Param("recurrente") boolean recurrente,
                         @Param("estado") String estado,
                         @Param("solicitud") String solicitud );
}
