package services.impl;

import com.google.inject.Inject;
import entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import persistence.*;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

import javax.ejb.Singleton;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class RecursosBibliotecaImpl implements RecursosBiblioteca {

    @Inject
    private HorarioDAO horarioDAO;

    @Inject
    private RecursoDAO recursoDAO;

    @Inject
    private ReservaDAO reservaDAO;

    @Inject
    private ReservaRecurrenteDAO reservaRecurrenteDAO;

    @Inject
    private TipoRecursoDAO tipoRecursoDAO;

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario buscarUsuario(String correo) throws ExceptionRecursosBiblioteca {
        try{
            return usuarioDAO.buscarUsuario(correo);
        }catch (PersistenceException e){
            throw new ExceptionRecursosBiblioteca("Error al buscar ese usuario: " + correo, e);
        }
    }

    @Override
    public List<Horario> consultarHorario(int id) throws ExceptionRecursosBiblioteca {
        try {
            return horarioDAO.load(id);
        } catch (ExceptionRecursosBiblioteca e){
            throw new ExceptionRecursosBiblioteca("error");
        }

    }

    @Override
    public void registratHorario() {

    }

    @Override
    public void registrarHorario(Horario h) {
        horarioDAO.save(h);
    }

    @Override
    public Recurso consultarRecurso(int id) {
        return recursoDAO.load(id);
    }

    @Override
    public Recurso consultarRecursosPorId(int id) {
        return recursoDAO.consultarRecursosPorId(id);
    }

    @Override
    public void registrarRecurso(String nombre, String habilitado, String ubicacion, int ejemplar, TipoRecurso tipo, int capacidad) throws ExceptionRecursosBiblioteca{
        try{
            recursoDAO.registrarRecurso(nombre, habilitado, ubicacion, ejemplar, tipo, capacidad);
        }catch (Exception e){
            throw new ExceptionRecursosBiblioteca("Error");
        }

    }

    @Override
    public void registrarRegusrso(Recurso r) {
        recursoDAO.save(r);
    }

    @Override
    public List<Recurso> consultarRecursos() {
        return recursoDAO.consultarRecursos();
    }

    @Override
    public List<Recurso> consultarRecursosPorTipo(int tipo) {
        return recursoDAO.consultarRecursosPorTipo(tipo);
    }

    @Override
    public ReservaRecurrente consultarReservaRecurrente(int id) {
        return reservaRecurrenteDAO.load(id);
    }

    @Override
    public void registrarReservaRecurrente() {

    }

    @Override
    public void registrarReservaRecurrente(ReservaRecurrente r) {
        reservaRecurrenteDAO.save(r);
    }

    @Override
    public TipoRecurso consultarTipo(int id) {
        return tipoRecursoDAO.load(id);
    }

    @Override
    public void registarrTipo() {

    }

    @Override
    public void registrarTipo(TipoRecurso t) {
        tipoRecursoDAO.save(t);
    }

    @Override
    public Usuario consultarUsuario(int id) {
        return usuarioDAO.load(id);
    }

    @Override
    public void registrarUsuario() {

    }

    @Override
    public Usuario consultarUsuarioPorId(int id) {
        return usuarioDAO.consultarUsuarioPorId(id);
    }

    @Override
    public void registrarUsuario(Usuario u) {
        usuarioDAO.save(u);
    }

    @Override
    public List<Recurso> consultarRecursosPorCapacidad(int i) {
        return recursoDAO.consultarRecursosPorCapacidad(i);
    }

    @Override
    public List<Recurso> consultarRecursosPorUbicacion(String ubi) {
        return recursoDAO.consultarRecursosPorUbicacion(ubi);
    }

    @Override
    public void reservarRecursos(Usuario usuario, Recurso recurso, Timestamp inicio, Timestamp fin, boolean recurrente, String estado, String solicitud)throws ExceptionRecursosBiblioteca{
        try{
            reservaDAO.reservarRecurso(usuario,recurso,inicio,fin,recurrente,estado,solicitud);
        }catch (Exception e){
            throw new ExceptionRecursosBiblioteca("Error");
        }

    }

    @Override
    public List<Recurso> consultarRecursosPorTipoCapacidadUbicacion(int tipo, int capacidad, String ubicacion) {
        return recursoDAO.consultarRecursosPorTipoCapacidadUbicacion(tipo,capacidad,ubicacion);
    }

    @Override
    public List<Recurso> consultarRecursosPorTipoYCapacidad(int tipo, int capacidad) {
        return recursoDAO.consultarRecursosPorTipoYCapacidad(tipo,capacidad);
    }

    @Override
    public List<Recurso> consultarRecursosPorTipoYUbicacion(int tipo, String ubicacion) {
        return recursoDAO.consultarRecursosPorTipoYUbicacion(tipo,ubicacion);
    }

    @Override
    public List<Recurso> consultarRecursosPorUbicacionYCapacidad(String ubicacion, int capacidad) {
        return recursoDAO.consultarRecursosPorUbicacionYCapacidad(ubicacion,capacidad);
    }

    @Override
    public List<Reserva> consultarReservas(){
        return reservaDAO.consultarReservas();
    }

    @Override
    public ReservaInformacion consultarReservaExtendida(int id, Usuario user) {
        Reserva reservas = reservaDAO.consultarReservaExtendida(id);

        Recurso recurso = consultarRecursosPorId(reservas.getIdRecurso().getId());
        ReservaInformacion reserva = (new ReservaInformacion(reservas.getId(), recurso.getNombre(),
                reservas.getSolicitud(), reservas.getInicio(), reservas.getFin(), user.getNombre(),
                user.getPrograma(), reservas.isRecurrente()));
        return reserva;
    }

    @Override
    public List<Reserva> consultarReservasActivas(int id) {
        return reservaDAO.consultarReservasActivas(id);
    }

    @Override
    public List<Reserva> consultarReservasCanceladas(int id) {
        return reservaDAO.consultarReservasCanceladas(id);
    }

    @Override
    public List<Reserva> consultarReservasPasadas(int id) {
        return reservaDAO.consultarReservasPasadas(id);
    }
}
