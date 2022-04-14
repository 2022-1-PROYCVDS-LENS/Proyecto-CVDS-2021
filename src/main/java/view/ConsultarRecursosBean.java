package view;


import com.google.inject.Inject;
import samples.entities.Recurso;
import samples.services.RecursosBiblioteca;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "ConsultarRecursos")
@ApplicationScoped
public class ConsultarRecursosBean extends BasePageBean{
    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    private Recurso recurso;


    public List<Recurso> consultarRecurso() {
        return recursosBiblioteca.consultarRecursos();
    }
}
