package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Departamento {
    @Id
    @Column(name="department_id")
    private Integer id;
    @Column(name="department_name")
    private String name;
    @Column(name="first_name")
    private String empleado;
    
    public Departamento() {
    }
    public Departamento(Integer id, String name,String empleado) {
        this.id=id;
        this.name=name;
        this.empleado=empleado;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}
