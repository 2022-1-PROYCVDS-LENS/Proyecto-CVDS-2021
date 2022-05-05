package security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;


public class OnlyNotAutenticate extends AccessControlFilter{

    private String welcomeUrl;


    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject usuario = getSubject(servletRequest, servletResponse);
        return !usuario.isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        welcomeUrl = "/recursosBiblioteca/login.xhtml";
        WebUtils.issueRedirect(servletRequest, servletResponse, welcomeUrl);
        return false;
    }

    public String getWelcomeUrl(){return welcomeUrl;}

    public void setWelcomeUrl(String welcomeUrl){this.welcomeUrl = welcomeUrl;}

}
