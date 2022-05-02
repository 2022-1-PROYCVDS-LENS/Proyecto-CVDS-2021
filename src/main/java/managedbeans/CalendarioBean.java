package managedbeans;

//import com.google.inject.Inject;
//import entities.Reserva;
//import org.primefaces.model.DefaultScheduleEvent;
//import org.primefaces.model.DefaultScheduleModel;
//import org.primefaces.model.ScheduleEvent;
//import org.primefaces.model.ScheduleModel;
//import services.RecursosBiblioteca;
//
//import javax.faces.bean.ManagedBean;
//import javax.enterprise.context.SessionScoped;
//import java.io.Serializable;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@ManagedBean(name = "reservaBean")
//@SessionScoped
//public class CalendarioBean extends BasePageBean implements Serializable {
//
//    //    @ManagedProperty(value = "#{param.recursoID}")
//    private int recursoID = 0;
//    private static final long serialVersionUID = 3594009161252782831L;
//
//    @Inject
//    private RecursosBiblioteca serviciosBiblioteca;
//
//    private ScheduleModel eventModel = new DefaultScheduleModel();
//    private ScheduleEvent event = new DefaultScheduleEvent();
//    private ScheduleEvent eventAux = new DefaultScheduleEvent();
//    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//    private String duracion;
//    private String fretiempo;
//    private Reserva reserva;
//    private Date nextDate;
//    private Reserva resssss;
//    private int resId = 0;
//
//    public int getResId() {
//        return resId;
//    }
//
//    public void setResId(int resId) {
//        this.resId = resId;
//    }
//
//
//    public Date getNextDate() {
//        return nextDate;
//    }
//
//    public void setNextDate(Date nextDate) {
//        this.nextDate = nextDate;
//    }
//
//    public int getRecursoID() {
//        return recursoID;
//    }
//
//    public void setRecursoID(int recursoID) {
//        this.recursoID = recursoID;
//    }
//
////    public TipoReserva getFrecuencia() {
////        return frecuencia;
////    }
//
////    public void setFrecuencia(TipoReserva frecuencia) {
////        this.frecuencia = frecuencia;
////    }
//
//    private int datee;
//
////    public TipoReserva[] getTipos() {
////        return TipoReserva.values();
////    }
//
//    public int getDatee() {
//        return datee;
//    }
//
//    public void setDatee(int datee) {
//        this.datee = datee;
//    }
//
//
//
//
//    public void loadEvents() {
//        eventModel = new DefaultScheduleModel();
//        List<Reserva> reservas = serviciosBiblioteca.consultarReservas();
//        for (Reserva r : reservas){
//            event = new DefaultScheduleEvent(String.valueOf(r.getId()), r.getInicio(), r.getFin());
//            eventModel.addEvent(event);
//            event.setId(String.valueOf(r.getId()));
//
//        }
        //Mouseky herramienta misteriosa
//        reservas.stream().map((reserva) -> {
//            event = new DefaultScheduleEvent(reserva.getTitulo(), reserva.getDataInicio(), reserva.getDataFim());
//
//            return reserva;
//        }).forEachOrdered((_item) -> {
//            eventModel.addEvent(event);
//
//        });

//    }




//}

//import java.io.Serializable;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.*;
//import javax.faces.context.FacesContext;
//import javax.faces.event.ActionEvent;
//import javax.faces.view.ViewScoped;
//
//import com.google.inject.Inject;
//import entities.Reserva;
//import org.primefaces.event.ScheduleEntryMoveEvent;
//import org.primefaces.event.ScheduleEntryResizeEvent;
//import org.primefaces.event.SelectEvent;
//import org.primefaces.model.DefaultScheduleEvent;
//import org.primefaces.model.DefaultScheduleModel;
//import org.primefaces.model.LazyScheduleModel;
//import org.primefaces.model.ScheduleEvent;
//import org.primefaces.model.ScheduleModel;
//import persistence.ReservaDAO;
//import services.RecursosBiblioteca;
//
//@SuppressWarnings("deprecation")
//@ManagedBean(name = "calendarioBean")
//@ReferencedBean
//public class CalendarioBean implements Serializable {
//
//    private ScheduleModel eventModel;
//
//    private ScheduleModel lazyEventModel;
//
//    private ScheduleEvent event = new DefaultScheduleEvent();
//
////    private RecursosBiblioteca recursosBiblioteca;
//
//    @Inject
//    private RecursosBiblioteca recursosBiblioteca;
//
//    private List<Reserva> reservas;
//
//    public void anadir(){
//        eventModel = new DefaultScheduleModel();
//
//
//    }
//
//    public ScheduleModel getScheduleEvent(){
//        anadir();
//        return eventModel;
//    }
//
//    public void consultarReservas(){
//        reservas = recursosBiblioteca.consultarReservas();
//
//    }
//
//    @PostConstruct
//    public void init() {
//        eventModel = new DefaultScheduleModel();
//        eventModel.addEvent(new DefaultScheduleEvent("prueba", reservas.get(0).getInicio(), reservas.get(0).getFin()));
//        eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
//        eventModel.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
//        eventModel.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
//        eventModel.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));
//
//        lazyEventModel = new LazyScheduleModel() {
//
//            @Override
//            public void loadEvents(Date start, Date end) {
//                Date random = getRandomDate(start);
//                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));
//
//                random = getRandomDate(start);
//                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
//            }
//        };
//    }
//
//    public Date getRandomDate(Date base) {
//        Calendar date = Calendar.getInstance();
//        date.setTime(base);
//        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
//
//        return date.getTime();
//    }
//
//    public Date getInitialDate() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
//
//        return calendar.getTime();
//    }
//
//    public ScheduleModel getEventModel() {
//        return eventModel;
//    }
//
//    public ScheduleModel getLazyEventModel() {
//        return lazyEventModel;
//    }
//
//    private Calendar today() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
//
//        return calendar;
//    }
//
//    private Date previousDay8Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 8);
//
//        return t.getTime();
//    }
//
//    private Date previousDay11Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 11);
//
//        return t.getTime();
//    }
//
//    private Date today1Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 1);
//
//        return t.getTime();
//    }
//
//    private Date theDayAfter3Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 3);
//
//        return t.getTime();
//    }
//
//    private Date today6Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.HOUR, 6);
//
//        return t.getTime();
//    }
//
//    private Date nextDay9Am() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.AM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
//        t.set(Calendar.HOUR, 9);
//
//        return t.getTime();
//    }
//
//    private Date nextDay11Am() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.AM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
//        t.set(Calendar.HOUR, 11);
//
//        return t.getTime();
//    }
//
//    private Date fourDaysLater3pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
//        t.set(Calendar.HOUR, 3);
//
//        return t.getTime();
//    }
//
//    public ScheduleEvent getEvent() {
//        return event;
//    }
//
//    public void setEvent(ScheduleEvent event) {
//        this.event = event;
//    }
//
//    public void addEvent(ActionEvent actionEvent) {
//        if(event.getId() == null)
//            eventModel.addEvent(event);
//        else
//            eventModel.updateEvent(event);
//
//        event = new DefaultScheduleEvent();
//    }
//
//    public void onEventSelect(SelectEvent selectEvent) {
//        event = (ScheduleEvent) selectEvent.getObject();
//    }
//
//    public void onDateSelect(SelectEvent selectEvent) {
//        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
//    }
//
//    public void onEventMove(ScheduleEntryMoveEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
//
//        addMessage(message);
//    }
//
//    public void onEventResize(ScheduleEntryResizeEvent event) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
//
//        addMessage(message);
//    }
//
//    private void addMessage(FacesMessage message) {
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//}