/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model.EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import realstate.Book;
import realstate.model.Manager;

/**
 *
 * @author Mausam Rayamajhi
 */
@Stateless
public class ManagerEJB {
      // Attributes             
    @PersistenceContext(unitName = "W8P1PU")
    private EntityManager em;

    // Public Methods           
    public List<Manager> findManagers() {
        TypedQuery<Manager> query = em.createNamedQuery("findAllManagers", realstate.model.Manager.class);
        return query.getResultList();
    }

    public Manager createManager(Manager manager) {
        em.persist(manager);
        return manager;
    }
    
    public Manager findById(Long managerId) {
        Manager manager = em.find(Manager.class, managerId);
        if (manager == null) {
            throw new EntityNotFoundException("Can't find Manager for ID "
                + managerId);
        }
        return manager;
    }
    
    public Manager searchManager(String firstName,String lastName) {
//        Manager manager = em.find(Manager.class, managerId);
//        if (manager == null) {
//            throw new EntityNotFoundException("Can't find Artist for ID "
//                + managerId);
//        }
//        return manager;
return null;
    }
}