package managedbeans;

import com.google.inject.Inject;
import entities.Recurso;
import entities.Usuario;
import lombok.Getter;
import lombok.Setter;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Time;

@SuppressWarnings("deprecation")
@ManagedBean(name = "reservarRecursoBean")
@SessionScoped
public class ReservarRecursoBean extends BasePageBean {

    @Getter @Setter Usuario usuario;
    @Getter @Setter Recurso recurso;
    @Getter @Setter Time inicio;
    @Getter @Setter Time fin;
    @Getter @Setter boolean recurrente;
    @Getter @Setter String estado;
    @Getter @Setter String solicitud;

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    public void reservarRecurso() throws ExceptionRecursosBiblioteca{
        try{
            recursosBiblioteca.reservarRecursos(usuario,recurso,inicio,fin,recurrente,estado,solicitud);
        }catch (Exception e){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error Cliente", "No se pudo reservar el recurso"));
    }
    }

}