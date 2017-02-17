package view.database;

import java.io.IOException;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.ejb.EJB;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import model.Departments;
import model.Employees;

import model.session.FacadeEJB;
import model.session.SessionEJB;

import view.message.MessagesView;

@ManagedBean(name="employeesView")
@ViewScoped
@ApplicationScoped
public class EmployeesView {
    
    @ManagedProperty("#{message}")
    private MessagesView messagesView;
    
    private List<Employees> employees;
    private List<Departments> departments;
    private Departments selectedDepartment = new Departments();
    private Employees employeesNew = new Employees();
    private Employees employeesEdit = new Employees();
    private Employees employeesSelected = new Employees();
    
    @EJB
    private SessionEJB modelo;
            
    @PostConstruct
    public void init() { 
        this.getSession();
        employees = modelo.getEmployeesFindAll();
        departments=modelo.getDepartmentsFindAll();
    } 
    
    public String getSession(){   
        String session ="";
        if(SessionUtils.getSession() == null){
            try {
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .redirect("login.jsf");
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return session;
    }

    public EmployeesView() {
        
    }

    public void setSelectedDepartment(Departments selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public Departments getSelectedDepartment() {
        return selectedDepartment;
    }
    
    public void save(){
        try{
            employeesNew.setDepartments(selectedDepartment);
            modelo.persistEmployees(employeesNew);  
            messagesView.info("save complet");
            this.init();
        }catch(Exception e){            
            messagesView.error("Error from save: "+e.getMessage());
        }
    }
    
    public void edit(){
        try{
            employeesSelected.setDepartments(selectedDepartment);
            modelo.mergeEmployees(employeesSelected); 
            messagesView.info("Actualizado Correctamente");
            this.init();
        }catch(Exception e){            
            messagesView.error("Error from Edit: "+e.getMessage());
        }
    }   

    public void delete(){
        try{
            modelo.removeEmployees(employeesSelected);
            messagesView.info("Eliminado Correctamente");
            this.init();
        }catch(Exception e){            
            messagesView.error("Error from Delete Departments: "+e.getMessage());
        }
    }
    
    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    public List<Departments> getDepartments() {        
        return departments;
    }
    
    public List<Departments> getDepartmentsSelectOneMenu() {
        List<Departments> departamentsSelectOneMenu = departments;
        if(employeesSelected.getEmployee_id()!=null)
            for(Departments d:departamentsSelectOneMenu)
                if(d.isEqual(employeesSelected.getDepartments())){
                    departamentsSelectOneMenu.remove(d);
                    break;
                }
                    
        return departamentsSelectOneMenu;
    }
    
    public void setEmployeesSelected(Employees employeesSelected) {
        this.employeesSelected = employeesSelected;
    }

    public Employees getEmployeesSelected() {
        return employeesSelected;
    }

    public void setMessagesView(MessagesView messagesView) {
        this.messagesView = messagesView;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployeesNew(Employees employeesNew) {
        this.employeesNew = employeesNew;
    }

    public Employees getEmployeesNew() {
        return employeesNew;
    }

    public void setEmployeesEdit(Employees employeesEdit) {
        this.employeesEdit = employeesEdit;
    }

    public Employees getEmployeesEdit() {
        return employeesEdit;
    }
}
