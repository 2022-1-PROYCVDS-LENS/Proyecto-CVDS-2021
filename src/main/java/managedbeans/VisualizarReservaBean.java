package managedbeans;

import entities.Recurso;
import entities.Reserva;
import entities.Usuario;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.sql.Time;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name = "visualizarReservaBean")
@SessionScoped
public class VisualizarReservaBean extends BasePageBean{
    @ManagedProperty(value = "#{user}")
    @Inject
    private RecursosBiblioteca rebi;
    Usuario user;
    Recurso recurso;
    Time inicio = new Time(System.currentTimeMillis());
    Time fin;
    boolean recurrente;
    String estado;
    String solicitud;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    List<Reserva> reservas;




    /**
     * Asigna a reservas las activas del usuario
     */
    public void consAct(){
        reservas= rebi.consultarReservasActivas(user.getId());
    }

    /**
     * Asigna a reservas las canceladas del usuario
     */
    public void consCanc(){
        reservas = rebi.consultarReservasCanceladas(user.getId());
    }

    /**
     * Asigna a reservas las pasadas del usuario
     */
    public void consPas(){
        reservas = rebi.consultarReservasPasadas(user.getId());
    }

}
