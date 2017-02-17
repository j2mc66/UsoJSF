package model.session;

import java.util.List;

import javax.ejb.Remote;

import model.Departments;
import model.Employees;

@Remote
public interface SessionEJB {
    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Departments persistDepartments(Departments departments);

    Departments mergeDepartments(Departments departments);

    void removeDepartments(Departments departments) throws Exception;

    List<Departments> getDepartmentsFindAll();

    Employees persistEmployees(Employees employees);

    Employees mergeEmployees(Employees employees);

    void removeEmployees(Employees employees);

    List<Employees> getEmployeesFindAll();
}
