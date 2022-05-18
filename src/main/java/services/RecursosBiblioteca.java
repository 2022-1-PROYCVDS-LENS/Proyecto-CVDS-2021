package services;

import entities.*;
import entities.Usuario;
import org.bouncycastle.util.Times;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface RecursosBiblioteca {

    public Usuario buscarUsuario(String correo) throws ExceptionRecursosBiblioteca;

    List<Horario> consultarHorario(int id) throws ExceptionRecursosBiblioteca;


    public abstract  void registrarRecurso(String nombre, String habilitado, String ubicacion, int ejemplar, TipoRecurso tipo, int capacidad) throws ExceptionRecursosBiblioteca;

    public abstract List<Recurso> consultarRecursos();
    public abstract List<Recurso> consultarRecursosPorTipo(int tipo);


    List<Recurso> consultarRecursosPorCapacidad(int i);

    List<Recurso> consultarRecursosPorUbicacion(String ubi);

    public abstract  void reservarRecursos(int usuario, int recurso, Timestamp inicio, Timestamp fin, boolean recurrente, String estado,Time hIni,Time hFin, Timestamp solicitud)throws ExceptionRecursosBiblioteca;

    List<Recurso> consultarRecursosPorTipoCapacidadUbicacion(int tipo, int capacidad, String ubicacion);

    List<Recurso> consultarRecursosPorTipoYCapacidad(int tipo, int capacidad);

    List<Recurso> consultarRecursosPorTipoYUbicacion(int tipo, String ubicacion);

    List<Recurso> consultarRecursosPorUbicacionYCapacidad(String ubicacion, int capacidad);

    List<Reserva> consultarReservasActivas(int id);

    List<Reserva> consultarReservasCanceladas(int id);

    List<Reserva> consultarReservasPasadas(int id);
    List<Reserva> consultarReservas();
    Recurso consultarNombreRecurso(int id);

    List<Reserva> consultarReservasPorUsuario(int id);

    void agregarHorarios(String[] horarios);
}
