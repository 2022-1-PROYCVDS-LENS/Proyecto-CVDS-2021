package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import org.checkerframework.framework.qual.InvisibleQualifier;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

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

    void cancelarReserva(){
        rebi.cancelarReserva(idReserva);
    }
}
