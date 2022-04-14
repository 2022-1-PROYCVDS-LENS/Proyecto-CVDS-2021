package samples.services;

import sampleprj.dao.mybatis.mappers.RecursoMapper;
import samples.entities.Recurso;

import java.util.List;

public class main {
    public static  void main(String[] args){
        RecursosBiblioteca instance = RecursosBibliotecaFactory.getInstance().getRecursosBiblioteca();
//        System.out.println(instance.consultarCliente(2165711).toString());
        List<Recurso> recursos = instance.consultarRecursos();
            for(Recurso r: recursos){
            System.out.println(r.toString());
        }

    }
}
