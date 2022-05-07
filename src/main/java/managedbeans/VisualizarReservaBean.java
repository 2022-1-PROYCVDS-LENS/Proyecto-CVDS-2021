package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import entities.Reserva;
import entities.Usuario;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.sql.Time;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "visualizarReservaBean")
@SessionScoped
public class VisualizarReservaBean extends BasePageBean{
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

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
    List<Reserva> reservas;
    Reserva reserva;

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void init(){
        this.user = loginBean.getUser();
        reservas = recursosBiblioteca.consultarReservasActivas(user.getId());
    }

    /**
     * Asigna a reservas las activas del usuario
     */
    public void consAct(){
        reservas= recursosBiblioteca.consultarReservasActivas(user.getId());
    }

    /**
     * Asigna a reservas las canceladas del usuario
     */
    public void consCanc(){
        reservas = recursosBiblioteca.consultarReservasCanceladas(user.getId());
    }

    /**
     * Asigna a reservas las pasadas del usuario
     */
    public void consPas(){
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
