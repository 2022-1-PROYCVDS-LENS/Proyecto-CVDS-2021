package managedbeans;

import com.google.inject.Inject;
import entities.Recurso;
import entities.TipoRecurso;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "registrarRecursosBean")
@SessionScoped
public class RegistrarRecursosBean extends BasePageBean{
    private final List<String> pos = Arrays.asList("libro", "sala de estudio", "Equipo de computo");
    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    public void registrar(String nombre, String habilitado, String ubicacion, String tipo, int capacidad) throws ExceptionRecursosBiblioteca {
        System.out.println(pos.indexOf(tipo) + 1);
        try{
            TipoRecurso tipor = new TipoRecurso();
            tipor.setId(pos.indexOf(tipo) + 1);
            tipor.setNombre(tipo);
            recursosBiblioteca.registrarRecurso(nombre, habilitado, ubicacion, tipor, capacidad);
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error recurso", "Información no valida"));
        }

    }
}
