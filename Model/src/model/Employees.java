package model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Employees.findAll", query = "select o from Employees o") })
@Table(name = "\"employees\"")
public class Employees implements Serializable {
    private static final long serialVersionUID = -3195276592865158465L;
    @Column(name = "commission_pct")
    private Double commission_pct;
    @Column(name = "email", nullable = false)
    private String email;
    @Id
    @Column(name = "employee_id", nullable = false)
    private Integer employee_id;
    @Column(name = "first_name")
    private String first_name;
    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date", nullable = false)
    private Date hire_date;
    @Column(name = "job_id", nullable = false)
    private String job_id;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "manager_id")
    private Integer manager_id;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "salary")
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "department_id" , nullable = false)
    private Departments departments;

    public Employees() {        
    }

    public Employees(double commission_pct, Departments departments, String email, Integer employee_id,
                         String first_name, Date hire_date, String job_id, String last_name, Integer manager_id,
                     String phone_number, Integer salary) {
        this.commission_pct = commission_pct;
        this.departments = departments;
        this.email = email;
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.last_name = last_name;
        this.manager_id = manager_id;
        this.phone_number = phone_number;
        this.salary = salary;
    }
    
    public boolean isEqual(Employees employees){
        return false;
    }

    public Double getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(Double commission_pct) {
        this.commission_pct = commission_pct;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}
