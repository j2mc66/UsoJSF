package view.database;

import javax.faces.context.FacesContext;

public class JsfUtil {
    public JsfUtil() {
        
    }
    
    public static enum PersistAction {
        CREATE,
        DELETE,
        UPDATE
    }
    
    public static boolean isValidationFailed() {
            return FacesContext.getCurrentInstance().isValidationFailed();
        }
}
