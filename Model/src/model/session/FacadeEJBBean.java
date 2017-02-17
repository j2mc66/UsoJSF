package model.session;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Departments;
import model.Employees;

@Stateless(name = "FacadeEJB", mappedName = "UsoJSF-Model-SessionEJB")
public class FacadeEJBBean implements FacadeEJB{
    
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    public FacadeEJBBean() {
    }
    
    @Override
    public List<Employees> getEmployeesFindAll() {
        return em.createNamedQuery("Employees.findAll", Employees.class).getResultList();
    }
}
