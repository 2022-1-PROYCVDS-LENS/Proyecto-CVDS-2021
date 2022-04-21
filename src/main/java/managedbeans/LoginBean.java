package managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.sun.org.slf4j.internal.LoggerFactory;
import jdk.internal.loader.AbstractClassLoaderValue;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import com.sun.org.slf4j.internal.Logger;

@ManagedBean(name="loginBean")
@SessionScoped

public class LoginBean implements Serializable{
    private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
    private String usuario;
    private String contrasena;
    public boolean logeado = false;

    public void login(){
        Subject usuarioActual = SecurityUtils.getSubject();
        UsernamePasswordToken uPToken = new UsernamePasswordToken(getUser(), new Sha256Hash(getPasswd()).toHex());
        try{
            usuarioActual.login(uPToken);
            usuarioActual.getSession().setAttribute("correo", usuario);
            redirect();
            setLogeado(true);
        } catch (UnknownAccountException ex) {
            String errorMessage = "El usuario no se encuentra registrado";
            error(errorMessage);
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
            String errorMessage = "La contraseña que ingreso no es correcta";
            error(errorMessage);
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
            String errorMessage = "Error inesperado";
            error(errorMessage);
            log.error(ex.getMessage(), ex);
        }
    }
    public String getUser() {
        return usuario;
    }

    public void setUser(String user) {
        this.usuario = user;
    }

    public String getPasswd() {
        return contrasena;
    }

    public void setPasswd(String passwd) {
        this.contrasena = passwd;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    private void error(String message) {
        FacesContext.getCurrentInstance().addMessage("Shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", message));
    }

    public void logOut() {
        setLogeado(false);
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redirect(){
        try {
            Subject usuario = SecurityUtils.getSubject();
            if (usuario.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrador.xhtml");
            } else if (usuario.hasRole("Comunidad")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/comunidad.xhtml");
            }
        }catch (IOException e){
            error("Error desconocido: " + e.getMessage());
            log.error(e.getMessage(), e);
        }

    }
    
}
