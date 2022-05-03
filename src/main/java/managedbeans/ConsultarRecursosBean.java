package managedbeans;


import com.google.inject.Inject;
import entities.Recurso;
import services.RecursosBiblioteca;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Bean para la interfaz de usuario de la consulta de recursos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "consultarRecursosBean")
@SessionScoped
public class ConsultarRecursosBean extends BasePageBean {

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    List<Recurso> recursos;
    Recurso recurso;

    int tipo = -1;
    int capacidad = -1;
    String ubicacion = "";

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Retorna la lista de recursos del bean
     * @return lista de recursos del bean
     */
    public List<Recurso> getRecursos() {
        return recursos;
    }

    /**
     * Guarda en los recursos del bean, todos los recursos disponibles
     */
//    public List<Recurso> filtrarLosRecursos(){
//        if (tipo != -1){
//            recursos = recursosBiblioteca.consultarRecursosPorTipo(tipo);
//        }
//        else if (capacidad != -1){
//            recursos = recursosBiblioteca.consultarRecursosPorCapacidad(capacidad);
//        }
//        else if (!ubicacion.equals("")){
//            recursos = recursosBiblioteca.consultarRecursosPorUbicacion(ubicacion);
//        }
//        else {
//            recursos = recursosBiblioteca.consultarRecursos();
//        }
//        return recursos;
//
//    }

    public List<Recurso> filtrarLosRecursos(){
        //Si todos los elementos de filtro estan definidos buscamos por todas las caracteristicas
        if(tipo!=-1 && capacidad != -1 && !ubicacion.equals("")){
            recursos = recursosBiblioteca.consultarRecursosPorTipoCapacidadUbicacion(tipo,capacidad,ubicacion);
        }
        //Filtramos por tipo y capacidad
        else if(tipo != -1 && capacidad !=-1){
            recursos = recursosBiblioteca.consultarRecursosPorTipoYCapacidad(tipo,capacidad);
        }
        //Filtramos por tipo y ubicacion
        else if(tipo != -1 && !ubicacion.equals("")){
            recursos = recursosBiblioteca.consultarRecursosPorTipoYUbicacion(tipo,ubicacion);
        }
        //Filtramos por ubicacion y capacidad
        else if(!ubicacion.equals("") && capacidad!=-1){
            recursos = recursosBiblioteca.consultarRecursosPorUbicacionYCapacidad(ubicacion,capacidad);
        }
        //Filtramos por tipo
        else if (tipo != -1){
            recursos = recursosBiblioteca.consultarRecursosPorTipo(tipo);
        }
        //Filtramos por capacidad
        else if (capacidad != -1){
            recursos = recursosBiblioteca.consultarRecursosPorCapacidad(capacidad);
        }
        //Filtramos por ubicacion
        else if (!ubicacion.equals("")){
            recursos = recursosBiblioteca.consultarRecursosPorUbicacion(ubicacion);
        }
        //En caso de que no se incluya ningun filtro buscamos todos los recursos
        else {
            recursos = recursosBiblioteca.consultarRecursos();
        }
        return recursos;
    }


}
