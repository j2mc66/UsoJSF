package model.facade;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Departamento;
import model.Departments;

@Stateless
public class DepartmentsFacade extends AbstractFacade<Departments> {
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentsFacade() {
        super(Departments.class);
    }
    
    public List<Departamento> nativeQueryObject(){
        Query query = em.createNativeQuery("SELECT d.department_id,d.department_name, e.first_name FROM departments d join employees e on d.department_id=e.department_id", Departamento.class);
        @SuppressWarnings("unchecked")
        List<Departamento> items = (List<Departamento>) query.getResultList();
        return items;
    }
    
}
