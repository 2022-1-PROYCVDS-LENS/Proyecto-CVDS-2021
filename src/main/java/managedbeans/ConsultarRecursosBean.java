package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import lombok.Getter;
import lombok.Setter;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Bean para la interfaz de usuario de la consulta de recursos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "consultarRecursosBean")
@SessionScoped
public class ConsultarRecursosBean extends BasePageBean {

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    @Getter @Setter List<Recurso> recursos;

    @Getter @Setter int tipo = -1;
    @Getter @Setter int capacidad = -1;
    @Getter @Setter String ubicacion = "";


    /**
     * Guarda en los recursos del bean, todos los recursos disponibles
     */
    public void filtrarLosRecursos(){
        if (tipo != -1){
            recursos = recursosBiblioteca.consultarRecursosPorTipo(tipo);
        }
        else if (capacidad != -1){
            recursos = recursosBiblioteca.consultarRecursosPorCapacidad(capacidad);
        }
        else if (!ubicacion.equals("")){
            recursos = recursosBiblioteca.consultarRecursosPorUbicacion(ubicacion);
        }
        else {
            recursos = recursosBiblioteca.consultarRecursos();
        }

    }

}
