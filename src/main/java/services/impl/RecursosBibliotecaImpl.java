package services.impl;

import com.google.inject.Inject;
import entities.*;
import persistence.*;
import services.RecursosBiblioteca;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
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
    public Horario consultarHorario(int id) {
        return horarioDAO.load(id);
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
    public void registrarRecurso(String nombre, String ubicacion, TipoRecurso tipo, int capacidad) {
        recursoDAO.registrarRecurso(nombre, ubicacion, tipo, capacidad);
    }

    @Override
    public void registrarRecusrso(Recurso r) {
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
    public void reservarRecurso(int id_usuario, int id_recurso, String inicio, String fin, boolean recurrente, String estado, String solicitud) {
        reservaDAO.reservarRecurso(id_usuario, id_recurso, inicio, fin, recurrente, estado, solicitud);
    }
}
