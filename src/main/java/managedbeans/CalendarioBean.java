package managedbeans;

import java.sql.Timestamp;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import lombok.Getter;
import lombok.Setter;
import com.google.inject.Inject;
import entities.Horario;
import entities.Reserva;
import org.primefaces.PrimeFaces;
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

    private ScheduleModel eventModel = new DefaultScheduleModel();;

    private ScheduleEvent event = new DefaultScheduleEvent();;

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    @Getter @Setter private List<Reserva> reservas;

    @Getter @Setter private Reserva reserva;

    private int eventId = 0;

    public List<Reserva> consul(){
        reservas = recursosBiblioteca.consultarReservas();
        return reservas;
    }

    public void loadEvents() {
        eventModel = new DefaultScheduleModel();
        reservas = recursosBiblioteca.consultarReservas();
//        Timestamp inicio = new Timestamp(2022, 5, 4, 7, 0, 0, 0);
//        Timestamp fin = new Timestamp(2022, 5, 4, 9, 0, 0, 0);
//        event = new DefaultScheduleEvent("prueba", inicio, fin);
        eventModel.addEvent(event);
        for (Reserva h : reservas){
            event = new DefaultScheduleEvent("prueba", h.getInicio(), h.getFin());
            eventModel.addEvent(event);
            event.setId("1");
            event.setId(String.valueOf(h.getId()));
        }
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent) selectEvent.getObject();
        this.eventId = Integer.parseInt(event.getId());
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