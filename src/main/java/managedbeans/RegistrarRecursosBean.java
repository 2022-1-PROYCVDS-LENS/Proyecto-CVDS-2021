package managedbeans;

import com.google.inject.Inject;
import entities.Recurso;
import entities.TipoRecurso;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.T;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Time;
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
    @Getter @Setter String[] horariosDisponibles;

    private final List<String> pos = Arrays.asList("libro", "sala de estudio", "Equipo de computo");
    @Inject
    private RecursosBiblioteca recursosBiblioteca;
    public void registrar() throws ExceptionRecursosBiblioteca {
//        prueba();
        try{
            TipoRecurso tipor = new TipoRecurso();
            tipor.setId(pos.indexOf(this.tipo) + 1);
            tipor.setNombre(this.tipo);
            recursosBiblioteca.registrarRecurso(this.nombre, this.habilitado, this.ubicacion, this.ejemplar, tipor, this.capacidad);
            recursosBiblioteca.agregarHorarios(this.horariosDisponibles);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "El recurso fue registrado"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", e.getMessage()));
        }
    }

    private void prueba(){
        String intento = "12:00";
        List<String> lista;
        lista = Arrays.asList(intento.split(":"));
        Time quiza = new Time(Integer.parseInt(lista.get(0)), Integer.parseInt(lista.get(1)), 0);
        System.out.println(quiza);

//        Time hola = new Time(12, 20, 30);
//        String prueba = "hola";
//        for (int i = 0; i < prueba.length(); i++){
//            System.out.println(prueba.charAt(i));
//        }
//        System.out.println(hola);
    }
}
