package managedbeans;

import com.google.inject.Inject;
import entities.ReservaInformacion;
import entities.Usuario;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "consultarReservaBean")
@SessionScoped
public class ConsultarReservaBean extends BasePageBean {
    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    private List<ReservaInformacion> reservas;
    private ReservaInformacion reserva;
    private int id;
    private Usuario user;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public void consultaExt() {
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        id = user.getId();
        reserva = recursosBiblioteca.consultarReservaExtendida(user.getId());
    }

    public List<ReservaInformacion> getReservas(){return reservas;}

    public void setReservas(List<ReservaInformacion> reservas){this.reservas = reservas;}

    public ReservaInformacion getReserva(){return reserva;}

    public void setReserva(ReservaInformacion reserva){this.reserva = reserva;}
}