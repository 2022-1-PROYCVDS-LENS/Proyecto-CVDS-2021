package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.services.impl.RecursosBibliotecaImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import edu.eci.cvds.services.RecursosBiblioteca;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
                bind(RecursosBiblioteca.class).to(RecursosBibliotecaImpl.class);
                bind(HorarioDAO.class).to(MyBATISHorarioDAO.class);
                bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
                bind(ReservaDAO.class).to(MyBATISReservaDAO.class);
                bind(ReservaRecurrenteDAO.class).to(MyBATISReservaRecurrenteDAO.class);
                bind(TipoRecursoDAO.class).to(MyBATISTipoRecursoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);

        //ServletContext servletContext = servletContextEvent.getServletContext();
        //servletContext.setAttribute(Injector.class.getName(), injector);
    }
}
