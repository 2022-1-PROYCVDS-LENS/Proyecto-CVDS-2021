package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import entities.Reserva;
import entities.Usuario;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Time;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "visualizarReservaBean")
@SessionScoped
public class VisualizarReservaBean extends BasePageBean{

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    Recurso recurso;
    Time inicio = new Time(System.currentTimeMillis());
    Time fin;
    boolean recurrente;
    String estado;
    private Usuario user;
    private int userId;
    String solicitud;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    List<Reserva> reservas;
    Reserva reserva;

    /**
     * Asigna a reservas las activas del usuario
     */
    public void consAct(){
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        userId = user.getId();
        reservas= recursosBiblioteca.consultarReservasActivas(1);
    }

    /**
     * Asigna a reservas las canceladas del usuario
     */
    public void consCanc(){
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        userId = user.getId();
        reservas = recursosBiblioteca.consultarReservasCanceladas(user.getId());
    }

    /**
     * Asigna a reservas las pasadas del usuario
     */
    public void consPas(){
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        userId = user.getId();
        reservas = recursosBiblioteca.consultarReservasPasadas(user.getId());
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
