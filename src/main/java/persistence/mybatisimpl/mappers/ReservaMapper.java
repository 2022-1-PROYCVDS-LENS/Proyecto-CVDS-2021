package persistence.mybatisimpl.mappers;

import entities.Reserva;

import java.util.List;

public interface ReservaMapper {

    List<Reserva> consultarReservas();
}
