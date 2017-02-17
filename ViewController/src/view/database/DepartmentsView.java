package view.database;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.ejb.EJBException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Departamento;
import model.Departments;

import model.facade.DepartmentsFacade;

import view.database.JsfUtil.PersistAction;

import view.message.MessagesView;

@ManagedBean(name="departmentsView")
@ViewScoped
public class DepartmentsView implements Serializable{
    
    private List<Departments> items;
    private Departments selected = null;
    
    @EJB
    private DepartmentsFacade modelo;

    @PostConstruct
    public void init() {
        //if(SessionUtils.getUserName() != null){
            this.getItems();
            List<Departamento> item = modelo.nativeQueryObject();
            System.out.println(item.get(0).getName());
        //}
        //else
        //    SessionUtils.logout();
    }
    
    public Departments prepareCreate() {
        selected = new Departments();
        return selected;
    }
    
    public void save(){
        persist(PersistAction.CREATE, "Guardado Correctamente");
        if (!JsfUtil.isValidationFailed()) {
            items = null;
        }
    }
    
    public void edit(){
        persist(PersistAction.UPDATE, "Actualizado Correctamente");
    }
    
    public void delete(){
        persist(PersistAction.DELETE, "Eliminado Correctamente");
        if (!JsfUtil.isValidationFailed()) {
            selected = null;
            items = null;
        }
    }

    public void setItems(List<Departments> items) {
        this.items = items;
    }

    public List<Departments> getItems() {
        if (items == null) {
            items = modelo.findAll();
        }
        return items;
    }
    
    public void setSelected(Departments selected) {
        this.selected = selected;
    }

    public Departments getSelected() {
        return selected;
    }
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                if (persistAction != PersistAction.DELETE) {
                    modelo.edit(selected);
                } else {
                    modelo.remove(selected);
                }
                MessagesView.info(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    MessagesView.error("Error action "+persistAction+" detail: "+msg);
                } else {
                    MessagesView.error(ex,"PersistenceErrorOccured");
                }
            } catch (Exception ex) {
                MessagesView.error(ex,"PersistenceErrorOccured");
                //Logger
            }
        }
    }
}