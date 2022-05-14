package managedbeans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import entities.Recurso;
import entities.Usuario;
import lombok.Getter;
import lombok.Setter;
import com.google.inject.Inject;
import entities.Horario;
import entities.Reserva;
import org.primefaces.PrimeFaces;
import org.primefaces.component.submenu.UISubmenu;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

@SuppressWarnings("deprecation")
@ManagedBean(name = "calendarioBean")
@ApplicationScoped
public class CalendarioBean extends BasePageBean {

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private DefaultScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    @Getter @Setter private List<Reserva> reservas;

    @Getter @Setter private Reserva reserva;

    @Getter @Setter public Recurso recurso;

    @Getter @Setter private ArrayList<String> recursos;

    @Getter @Setter private ArrayList<String> solicitudes;

    @Getter @Setter private String nombreR;

    @Getter @Setter private String solicitud;

    private int eventId = 0;

    public List<Reserva> consul(){
        reservas = recursosBiblioteca.consultarReservas();
        return reservas;
    }

    public ScheduleModel consultar(){
        loadEvents();
        return eventModel;
    }

    public Date getInicio(){
        return event.getStartDate();
    }

    public Date getFin(){
        return event.getEndDate();
    }

    public void consultarReservas(){

        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user") != null){
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        }

    }

    public void loadEvents() {
        recursos = new ArrayList<String>();
        solicitudes = new ArrayList<String>();
        eventModel = new DefaultScheduleModel();
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user") != null){
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            reservas = recursosBiblioteca.consultarReservasPorUsuario(user.getId());
        }else {
            reservas = recursosBiblioteca.consultarReservas();
        }
        int pos = 0;
        for (Reserva h : reservas){
            event = new DefaultScheduleEvent(" " + h.getUsuario().getNombre(), h.getInicio(), h.getFin());
            recursos.add(recursosBiblioteca.consultarNombreRecurso(h.getIdRecurso()).getNombre());
            solicitudes.add(h.getSolicitud().toString());
            event.setDescription(recursosBiblioteca.consultarNombreRecurso(h.getIdRecurso()).getNombre());
            eventModel.addEvent(event);
            event.setId(String.valueOf(pos));
            pos ++;
        }
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (DefaultScheduleEvent) selectEvent.getObject();
        this.eventId = Integer.parseInt(event.getId());
        this.nombreR = recursos.get(eventId);
        this.solicitud = solicitudes.get(eventId);
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    private void addMessage(FacesMessage message) {
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

}