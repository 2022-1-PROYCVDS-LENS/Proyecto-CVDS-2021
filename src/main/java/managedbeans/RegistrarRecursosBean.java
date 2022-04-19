package managedbeans;

import com.google.inject.Inject;
import entities.Recurso;
import entities.TipoRecurso;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "registrarRecursosBean")
@SessionScoped
public class RegistrarRecursosBean extends BasePageBean{
    private List<String> pos = Arrays.asList("libro", "sala de estudio", "Equipo de computo");
    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    public void registrar(String nombre, String habilitado, String ubicacion, String tipo, int capacidad){
        TipoRecurso tipor = new TipoRecurso();
        tipor.setId(pos.indexOf(tipo) + 1);
        tipor.setNombre(tipo);
        recursosBiblioteca.registrarRecurso(nombre, habilitado, ubicacion, tipor, capacidad);
    }
}
