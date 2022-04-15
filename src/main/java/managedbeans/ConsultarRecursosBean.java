package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Bean para la interfaz de usuario de la consulta de recursos
 */

@ManagedBean(name = "consultarRecursosBean")
@SessionScoped
public class ConsultarRecursosBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    private Recurso recurso;
    public List<Recurso> getRecursos() {
        return recursosBiblioteca.consultarRecursos();
    }

}
