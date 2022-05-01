package services.impl;

import com.google.inject.Inject;
import entities.*;
import org.apache.ibatis.exceptions.PersistenceException;
import persistence.*;
import services.ExceptionRecursosBiblioteca;
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
    public Usuario buscarUsuario(String correo) throws ExceptionRecursosBiblioteca {
        try{
            System.out.println(usuarioDAO);
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
}
