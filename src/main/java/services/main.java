package services;


import entities.Recurso;

import java.util.List;

public class main {
    public static  void main(String[] args){
        RecursosBiblioteca instance = RecursosBibliotecaFactory.getInstance().getRecursosBiblioteca();
//        System.out.println(instance.consultarCliente(2165711).toString());
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


    }
}
