package services;


import entities.Horario;
import entities.Recurso;
import entities.Reserva;
import entities.TipoRecurso;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class main {
    public static  void main(String[] args) throws ExceptionRecursosBiblioteca {
        RecursosBiblioteca instance = RecursosBibliotecaFactory.getInstance().getRecursosBiblioteca();
//        System.out.println(instance.consultarCliente(2165711).toString());
//        try{
//            instance.registrarRecurso("1", "disponible", "biblioteca", 1, new TipoRecurso(2, "sala de estudio"), 3);
//        }catch (Exception e){
//            System.out.println("error");
//        }
//        System.out.println("sin filtrar");
//        List<Recurso> recursos = instance.consultarRecursos();
//        for(Recurso r: recursos){
//            System.out.println(r.toString());
//        }
//        System.out.println("por tipo");
//        recursos = instance.consultarRecursosPorTipo(1);
//            for(Recurso r: recursos){
//            System.out.println(r.toString());
//        }
//        System.out.println("por capacidad");
//        recursos = instance.consultarRecursosPorCapacidad(4);
//        for(Recurso r: recursos){
//            System.out.println(r.toString());
//        }
//        System.out.println("por ubicacion");
//        recursos = instance.consultarRecursosPorUbicacion("biblioteca");
//        for(Recurso r: recursos){
//            System.out.println(r.toString());
//        }
        System.out.println("prueba horarios");
        List<Horario> horarios = instance.consultarHorario(3);
        for(Horario h: horarios){
            System.out.println(h.toString());
        }
//        List<Reserva> reservas = instance.consultarReservas();
//        for (Reserva r : reservas){
//            System.out.println(r.toString());
//        }
//        Date in = new Date();
//        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
//        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(out);
//        System.out.println(ldt);
//        System.out.println(in);


    }
}
