package model.session;

import java.util.List;

import javax.ejb.Remote;

import model.Departments;
import model.Employees;

@Remote
public interface FacadeEJB {
    List<Employees> getEmployeesFindAll();
}

