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
    public abstract  void registratHorario(//Parametros de gorario);
    );
    public abstract void registrarHorario(Horario h);
    public abstract Recurso consultarRecurso(int id);
    public abstract  void registrarRecurso(String nombre, String habilitado, String ubicacion, int ejemplar, TipoRecurso tipo, int capacidad) throws ExceptionRecursosBiblioteca;

    public abstract void registrarRegusrso(Recurso r);
    public abstract List<Recurso> consultarRecursos();
    public abstract List<Recurso> consultarRecursosPorTipo(int tipo);

    public abstract ReservaRecurrente consultarReservaRecurrente(int id);
    public abstract void registrarReservaRecurrente(//Parametros
    );
    public abstract void registrarReservaRecurrente(ReservaRecurrente r);

    public abstract TipoRecurso consultarTipo(int id);
    public abstract void registarrTipo(//partametros
    );
    public abstract void registrarTipo(TipoRecurso t);

    public abstract Usuario consultarUsuario(int id);
    public abstract void registrarUsuario(//parametros
    );
    public abstract void registrarUsuario(Usuario u);

    List<Recurso> consultarRecursosPorCapacidad(int i);

    List<Recurso> consultarRecursosPorUbicacion(String ubi);

    public abstract  void reservarRecursos(Usuario usuario, Recurso recurso, Timestamp inicio, Timestamp fin, boolean recurrente, String estado, String solicitud)throws ExceptionRecursosBiblioteca;

    List<Recurso> consultarRecursosPorTipoCapacidadUbicacion(int tipo, int capacidad, String ubicacion);

    List<Recurso> consultarRecursosPorTipoYCapacidad(int tipo, int capacidad);

    List<Recurso> consultarRecursosPorTipoYUbicacion(int tipo, String ubicacion);

    List<Recurso> consultarRecursosPorUbicacionYCapacidad(String ubicacion, int capacidad);
}
