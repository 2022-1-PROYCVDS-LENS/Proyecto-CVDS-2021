package managedbeans;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;

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

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    @Inject
    private RecursosBiblioteca recursosBiblioteca;

    private int eventId = 0;

    public void loadEvents() {
        eventModel = new DefaultScheduleModel();
        List<Reserva> reservas = recursosBiblioteca.consultarReservas();
        System.out.println(reservas.size());
        for (Reserva h : reservas){
            event = new DefaultScheduleEvent("prueba", h.getInicio(), h.getFin());
            eventModel.addEvent(event);
//            event.setId("1");
            event.setId(String.valueOf(h.getId()));
        }
        System.out.println(eventModel.getEventCount());
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