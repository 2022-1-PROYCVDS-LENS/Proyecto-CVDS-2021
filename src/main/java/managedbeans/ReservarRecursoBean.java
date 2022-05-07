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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservarRecursoBean")
@SessionScoped
public class ReservarRecursoBean extends BasePageBean {

    @Getter @Setter Usuario usuario =  new Usuario(1, "estudiante", "Esteban Torres", null, "esteban.torres@escuelaing.edu.co", "12345e");
    @Getter @Setter Recurso recurso;
    @Getter @Setter Timestamp inicio;
    @Getter @Setter Timestamp fin;
    @Getter @Setter boolean recurrente;
    @Getter @Setter String estado;
    @Getter @Setter String solicitud = new Timestamp(System.currentTimeMillis()).toString();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    public void reservarRecurso(int idRecurso) throws ExceptionRecursosBiblioteca{
        try{

            List<Recurso> rec = recursosBiblioteca.consultarRecursos();
            for (Recurso r : rec) {
                if (r.getId() == idRecurso) recurso = r;
            }
            System.out.println(usuario + " " + recurso + " " + inicio + " " + fin +" "+recurrente+" "+estado+" "+solicitud);
            recursosBiblioteca.reservarRecursos(usuario,recurso,inicio,fin,recurrente,estado,solicitud);
            System.out.println("aaaaaaaaaaa");
        }catch (Exception e){
        FacesContext.getCurrentInstance().addMessage("No se pudo reservar el recurso", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error Cliente", "No se pudo reservar el recurso"));
        e.printStackTrace();
        }
    }

}