package services;


import entities.*;
import entities.Recurso;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class main {
    public static  void main(String[] args) {
        RecursosBiblioteca instance = RecursosBibliotecaFactory.getInstance().getRecursosBiblioteca();
//        System.out.println(instance.consultarCliente(2165711).toString());

//        System.out.println("reservas");
//        List<Reserva> reservas = instance.consultarReservasActivas(1);
//        for (Reserva r: reservas){
//            System.out.println(r.toString());
//        }
//
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
//
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
//        System.out.println("prueba horarios");
//        List<Horario> horarios = instance.consultarHorario(3);
//        for(Horario h: horarios){
//            System.out.println(h.toString());
//        }


        try {
            Timestamp inicio = new Timestamp(22,5,17,12,0,0,0);
            Timestamp fin = new Timestamp(22,5,17,13,0,0,0);
            Timestamp hoy = new Timestamp(System.currentTimeMillis());
            Time hIni = new Time(12,0,0);
            Time hFin = new Time(13,0,0);
            instance.reservarRecursos(3,7, inicio,fin,false,"activo", hIni,hFin,hoy);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
