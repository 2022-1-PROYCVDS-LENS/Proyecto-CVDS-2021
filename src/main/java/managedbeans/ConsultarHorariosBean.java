package managedbeans;

import com.google.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean(name = "registrarRecursosBean")
@SessionScoped
public class ConsultarHorariosBean extends BasePageBean{

    @Getter @Setter String horas;
    @Getter @Setter String estado;

    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    public void consultarHorario(){

    }
}
