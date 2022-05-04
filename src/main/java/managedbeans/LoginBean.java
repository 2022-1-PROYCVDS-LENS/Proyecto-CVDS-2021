package managedbeans;

import java.io.IOException;
import java.util.logging.Level;

import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import com.google.inject.Inject;
import entities.Usuario;
import org.slf4j.LoggerFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import services.ExceptionRecursosBiblioteca;
import services.RecursosBiblioteca;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BasePageBean{

    private static final Logger log = LoggerFactory.getLogger(RecursosBiblioteca.class);
    private String usuario;
    private String contrasena;
    public boolean logeado = false;

    @Inject
    private RecursosBiblioteca rebi;

    public void login() throws Exception{

        Subject usuarioActual = SecurityUtils.getSubject();

        UsernamePasswordToken uPToken = new UsernamePasswordToken(getUsuario(), getContrasena());

        try{

            Usuario user = rebi.buscarUsuario(usuario);

            if (user != null){
                usuarioActual.login(uPToken);
                usuarioActual.getSession().setAttribute("Correo", usuario);
                redirect();
                setLogeado(true);
            }else{
             error("EL usuario no existe");
                System.out.println("_____ccccccaaaaaaaaaaaa_____________");
            }
        } catch (UnknownAccountException e) {
            System.out.println("_____cccccccaaaaaaaaa111111111_____________");
            String errorMensaje = "El usuario no esta registrado";
            error(errorMensaje);
            log.error(e.getMessage(), e);
        } catch (IncorrectCredentialsException e) {
            System.out.println("_____cccccccccbbbbbbbbbbb_____________");
            String errorMensaje = "La contraseña que ingreso es incorrecta";
            error(errorMensaje);
            log.error(e.getMessage(), e);
        } catch (LockedAccountException e) {
            System.out.println("_____cccccddddddddd_____________");
            String errorMensaje = "El usuario esta deshabilitado";
            error(errorMensaje);
            log.error(e.getMessage(), e);
        } catch (AuthenticationException e) {
            System.out.println("_____cccccccceeeeeeeeee_____________");
            String errorMensaje = "Error inesperado";
            error(errorMensaje);
            log.error(e.getMessage(), e);
        }finally {
            System.out.println("entro");
            uPToken.clear();
        }
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    private void error(String mensaje) {
        FacesContext.getCurrentInstance().addMessage("Shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", mensaje));
    }

    public void logOut() {
        setLogeado(false);
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/recursosBiblioteca/login.xhtml");
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void redirect(){
        try {
            Subject usuario = SecurityUtils.getSubject();
            if (usuario.hasRole("administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/recursosBiblioteca/administrador.xhtml");
            } else if (usuario.hasRole("estudiante")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/recursosBiblioteca/comunidad.xhtml");
            }
        }catch (IOException e){
            error("Error desconocido: " + e.getMessage());
            log.error(e.getMessage(), e);
        }
    }

}
