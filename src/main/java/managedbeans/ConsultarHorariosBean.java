package managedbeans;

import com.google.inject.Inject;
import entities.Horario;
import lombok.Getter;
import lombok.Setter;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "consultarHorariosBean")
@SessionScoped
public class ConsultarHorariosBean extends BasePageBean{

    @Getter @Setter String hora_ini;
    @Getter @Setter String hora_fin;
    @Getter @Setter int id;
    @Getter @Setter List<Horario> horarios;



    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    public void consultarHorario(int id){
        horarios = recursosBiblioteca.consultarHorario(id);

    }

    public void prueba(){
        System.out.println("si");
    }



}
