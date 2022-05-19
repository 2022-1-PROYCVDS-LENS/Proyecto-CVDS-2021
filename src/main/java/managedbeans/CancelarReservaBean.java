package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import org.checkerframework.framework.qual.InvisibleQualifier;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Bean para la interfaz de usuario de la consulta de recursos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "cancelarReservaBean")
@SessionScoped

public class CancelarReservaBean {
    @Inject
    RecursosBiblioteca rebi;

    int idReserva;

    public void cancelarReserva(int id_reserva){
        if (Objects.equals(rebi.consultarReservaPorId(id_reserva).getEstado(), "activo")){
            rebi.cancelarReserva(id_reserva);
        }
    }

    public boolean esCancelable(int id_reserva){
        return Objects.equals(rebi.consultarReservaPorId(id_reserva).getEstado(), "activo");
    }
}
