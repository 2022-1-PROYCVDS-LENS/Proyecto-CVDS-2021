package managedbeans;

import com.google.inject.Inject;
import entities.Horario;
import lombok.Getter;
import lombok.Setter;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "consultarHorariosBean")
@SessionScoped
public class ConsultarHorariosBean extends BasePageBean {

    @Getter @Setter String hora_ini;
    @Getter @Setter String hora_fin;
    @Getter @Setter int id;
    @Getter @Setter List<Horario> horarios;
    @Getter @Setter Horario horario;


    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    public List<Horario> consultarHorario(int id) throws ExceptionRecursosBiblioteca {
        try {
            horarios = recursosBiblioteca.consultarHorario(id);
            return horarios;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error ",e.getMessage()));
        }
        return horarios;
    }
}
