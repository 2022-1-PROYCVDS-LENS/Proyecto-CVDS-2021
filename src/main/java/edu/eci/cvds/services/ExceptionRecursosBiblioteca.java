package edu.eci.cvds.services;

public class ExceptionRecursosBiblioteca extends Exception{

    public ExceptionRecursosBiblioteca(String mensaje, Exception e){
        super(mensaje, e);
    }

    public ExceptionRecursosBiblioteca(String mensaje){
        super(mensaje);
    }
}
