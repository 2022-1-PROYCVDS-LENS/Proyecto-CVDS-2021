package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import services.RecursosBiblioteca;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "ConsultarRecursos")
@ApplicationScoped
public class ConsultarRecursosBean extends BasePageBean{
    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    private Recurso recurso;

/*
    public List<Recurso> consultarRecurso() {
        return recursosBiblioteca.consultarRecursos();
    }
    */

}
