package managedbeans;

import entities.Recurso;
import entities.Reserva;
import entities.Usuario;
import services.RecursosBiblioteca;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.sql.Time;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class visualizarReservaBean extends BasePageBean{

    @Inject
    private RecursosBiblioteca rebi;

    Usuario usuario;
    Recurso recurso;
    Time inicio = new Time(System.currentTimeMillis());
    Time fin;
    boolean recurrente;
    String estado;
    String solicitud;
    List<Reserva> reservasActuales;
    List<Reserva> reservasPasadas;
    List<Reserva> reservasCanceladas;

    public void consultarReservas(Usuario usuario){
        reservasActuales = rebi.consultarReservasActivas(usuario.getId());
        reservasCanceladas = rebi.consultarReservasCanceladas(usuario.getId());
        reservasPasadas = rebi.consultarReservasPasadas(usuario.getId());
    }
}
