package view.database;

import java.io.IOException;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import view.message.MessagesView;

public class SessionUtils {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("username");
        else
            return null;
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("userid");
        else
            return null;
    }
    
    public static void logout() {        
        getSession().invalidate();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
        } catch (IOException ex) {
            MessagesView.error(ex, "Error al terminar la session");
        }
    }
}