package services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import persistence.*;
import persistence.mybatisimpl.*;
import services.impl.*;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class RecursosBibliotecaFactory {
    private static RecursosBibliotecaFactory instance = new RecursosBibliotecaFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(RecursosBiblioteca.class).to(RecursosBibliotecaImpl.class);
                bind(HorarioDAO.class).to(MyBATISHorarioDAO.class);
                bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
                bind(ReservaDAO.class).to(MyBATISReservaDAO.class);
                bind(ReservaRecurrenteDAO.class).to(MyBATISReservaRecurrenteDAO.class);
                bind(TipoRecursoDAO.class).to(MyBATISTipoRecursoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
            }
        });
    }

    private RecursosBibliotecaFactory(){
        optInjector = Optional.empty();
    }

    public RecursosBiblioteca getRecursosBiblioteca(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(RecursosBiblioteca.class);
    }


    public RecursosBiblioteca getServiciosAlquilerTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(RecursosBiblioteca.class);
    }


    public static RecursosBibliotecaFactory getInstance(){
        return instance;
    }
}
