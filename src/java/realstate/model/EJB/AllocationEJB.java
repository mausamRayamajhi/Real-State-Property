/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model.EJB;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import realstate.model.Allocation;

/**
 *
 * @author Mausam Rayamajhi
 */
@Stateful
public class AllocationEJB {

    @PersistenceContext(unitName = "W8P1PU")
    private EntityManager em;

    public Allocation createAllocation(Allocation allocation) {
        em.persist(allocation);
        return allocation;
    }

    public List<Allocation> findAllAllocation() {
        TypedQuery<Allocation> query = em.createNamedQuery("findAllAllocation", Allocation.class);
        return query.getResultList();
    }

    public Allocation findById(Long id) {
        Allocation allocation = em.find(Allocation.class, id);
        
        if (allocation == null) {
            throw new EntityNotFoundException("Can't find allocation for ID "
                    + id);
        }
        return allocation;
    }

    public Allocation findByManagerId(Long id) {

        TypedQuery<Allocation> query = em.createNamedQuery("findByManagerId", Allocation.class);
        return query.getSingleResult();

    }
    
      public void delete(Allocation allocation) {

       
       em.remove(findById(allocation.getId()));

    }
}
