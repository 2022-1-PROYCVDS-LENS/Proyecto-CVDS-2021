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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservarRecursoBean")
@SessionScoped
public class ReservarRecursoBean extends BasePageBean {

    @Getter @Setter Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
    @Getter @Setter Recurso recurso;
    @Getter @Setter Date inicio;
    @Getter @Setter Date fin;
    @Getter @Setter boolean recurrente;
    @Getter @Setter Time horaIni;
    @Getter @Setter Time horaFin;
    @Getter @Setter String estado;
    @Getter @Setter Timestamp solicitud = new Timestamp(System.currentTimeMillis());
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    public void reservarRecurso(int idRecurso) throws ExceptionRecursosBiblioteca{
        try{
//            System.out.println("aaaaaaaaaaa");
            List<Recurso> rec = recursosBiblioteca.consultarRecursos();
            for (Recurso r : rec) {
                if (r.getId() == idRecurso) recurso = r;
            }
//            System.out.println(horaIni + "i");
//            System.out.println(horaFin+"f");
//            System.out.println(usuario.getId() + " " + recurso.getId() + " " + inicio + " " + fin +" "+recurrente+" "+estado+" "+solicitud);
            Timestamp fechaInicio = new Timestamp(inicio.getTime() + horaIni.getHours()*3600000);
            Timestamp fechaFin = new Timestamp(fin.getTime() + horaFin.getHours()*3600000);
            recursosBiblioteca.reservarRecursos(usuario.getId(),recurso.getId(),fechaInicio,fechaFin,recurrente,"activo",horaIni,horaFin,solicitud);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "El recurso fue reservado"));
        }catch (Exception e){
        FacesContext.getCurrentInstance().addMessage("No se pudo reservar el recurso", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error Cliente", "No se pudo reservar el recurso"));
        e.printStackTrace();
        }
    }

    public void setearHoras(Time inicio, Time fin){
        this.horaIni = inicio;
        this.horaFin = fin;
    }

}