package services;


import entities.*;
import entities.Recurso;

import java.util.List;

public class main {
    public static  void main(String[] args) {
        RecursosBiblioteca instance = RecursosBibliotecaFactory.getInstance().getRecursosBiblioteca();
//        System.out.println(instance.consultarCliente(2165711).toString());

        System.out.println("reservas");
        List<Reserva> reservas = instance.consultarReservasActivas(7);
        for (Reserva r: reservas){
            System.out.println(r.toString());
        }

        instance.cancelarReserva(7);



        System.out.println("sin filtrar");
        List<Recurso> recursos = instance.consultarRecursos();
        for(Recurso r: recursos){
            System.out.println(r.toString());
        }
        System.out.println("por tipo");
        recursos = instance.consultarRecursosPorTipo(1);
            for(Recurso r: recursos){
            System.out.println(r.toString());
        }
        System.out.println("por capacidad");
        recursos = instance.consultarRecursosPorCapacidad(4);
        for(Recurso r: recursos){
            System.out.println(r.toString());
        }
        System.out.println("por ubicacion");
        recursos = instance.consultarRecursosPorUbicacion("biblioteca");
        for(Recurso r: recursos){
            System.out.println(r.toString());
        }

        try{
            instance.registrarRecurso("1", "disponible", "biblioteca", 1, new TipoRecurso(2, "sala de estudio"), 3);
        }catch (Exception e){
            System.out.println("error");
        }
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


//        try {
//            Usuario u = new Usuario(1,"estudiante","Esteban Torres",null,"esteban.torres@escuelaing.edu.co","12345e");
//            List<Recurso> rec = instance.consultarRecursos();
//            Recurso recurso = null;
//            for(Recurso r:rec){
//                if (r.getId() == 7)  recurso = r;
//            }
//            instance.reservarRecursos(u,recurso, );
//        }

    }

}
