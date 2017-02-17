package model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Departments.findAll", query = "select o from Departments o") })
@Table(name = "\"departments\"")
public class Departments implements Serializable {
    private static final long serialVersionUID = -2532821353638182135L;
    @Id
    @Column(name = "department_id", nullable = false)
    private Integer department_id;
    @Column(name = "department_name", nullable = false)
    private String department_name;
    @Column(name = "location_id")
    private Integer location_id;
    @Column(name = "manager_id")
    private Integer manager_id;
    @OneToMany(mappedBy = "departments", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Employees> employeesList;

    public Departments() {
    }
    
    public boolean isEqual(Departments departments){
        boolean flag = false;
        if(departments.getDepartment_id().equals(department_id))
            flag=true;
        return flag;
    }

    public Departments(Integer department_id, String department_name, Integer location_id, Integer manager_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.location_id = location_id;
        this.manager_id = manager_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Employees addEmployees(Employees employees) {
        getEmployeesList().add(employees);
        employees.setDepartments(this);
        return employees;
    }

    public Employees removeEmployees(Employees employees) {
        getEmployeesList().remove(employees);
        employees.setDepartments(null);
        return employees;
    }
}
