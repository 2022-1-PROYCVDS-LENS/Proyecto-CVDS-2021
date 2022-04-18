package test;

import entities.Recurso;
import services.RecursosBiblioteca;
import services.RecursosBibliotecaFactory;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class bibliotecaTest {

    RecursosBiblioteca biblioteca;
    public bibliotecaTest(){
        biblioteca = RecursosBibliotecaFactory.getInstance().getRecursosBiblioteca();
    }
    @Test
    public void deberiaConsultarSinFiltro(){
        List<Recurso> recursos = biblioteca.consultarRecursos();
        String recu = recursos.get(0).toString();
        Assert.assertEquals(recursos.size(), Character.getNumericValue(recu.charAt(12)));

    }
    @Test
    public void deberiaConsultarPorTipo(){
        List<Recurso> recursos = biblioteca.consultarRecursosPorTipo(1);
        for (Recurso r: recursos){
            Assert.assertEquals("libro", r.getTipo().getNombre());
        }
        recursos = biblioteca.consultarRecursosPorTipo(4);
        for (Recurso r: recursos){
            Assert.assertEquals("equipo audiovisual", r.getTipo().getNombre());
        }
    }

    @Test
    public void deberiaConsultarPorCapacidad(){
        List<Recurso> recursos = biblioteca.consultarRecursosPorCapacidad(4);
        for(Recurso r: recursos){
            Assert.assertEquals(4, r.getCapacidad());
        }
    }

    @Test
    public void deberiaConsultarPorUbicacion(){
        List<Recurso> recursos = biblioteca.consultarRecursosPorUbicacion("Biblioteca");
        for(Recurso r: recursos){
            Assert.assertEquals("biblioteca", r.getUbicacion());
        }
    }
}
