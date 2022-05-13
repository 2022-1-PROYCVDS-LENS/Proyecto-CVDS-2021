package managedbeans;

import com.google.inject.Inject;
import entities.Recurso;
import entities.TipoRecurso;
import lombok.Getter;
import lombok.Setter;
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

    @Getter @Setter String nombre;
    @Getter @Setter String habilitado;
    @Getter @Setter String tipo;
    @Getter @Setter int capacidad;
    @Getter @Setter String ubicacion;
    @Getter @Setter int ejemplar;

    private final List<String> pos = Arrays.asList("libro", "sala de estudio", "Equipo de computo");
    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    public void registrar() throws ExceptionRecursosBiblioteca {
        System.out.println("xd");
        System.out.println(nombre + habilitado + tipo + ubicacion);
        System.out.println(capacidad);
        System.out.println(ejemplar);
        try{
            TipoRecurso tipor = new TipoRecurso();
            tipor.setId(pos.indexOf(this.tipo) + 1);
            tipor.setNombre(this.tipo);
            recursosBiblioteca.registrarRecurso(this.nombre, this.habilitado, this.ubicacion, this.ejemplar, tipor, this.capacidad);
            FacesMessage message = new FacesMessage("bien");
            FacesContext.getCurrentInstance().addMessage("bien", message);
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error Cliente", "ya hay un cliente registrado igual"));
        }

    }
}
