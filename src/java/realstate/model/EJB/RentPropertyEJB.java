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
import realstate.model.RentProperty;


/**
 *
 * @author Mausam Rayamajhi
 */
@Stateful
public class RentPropertyEJB {

    @PersistenceContext(unitName = "W8P1PU")
    private EntityManager em;
    
    public RentProperty createRentProperty(RentProperty property) {
         em.persist(property);
        return property;
    }

    public List<RentProperty> findRentPropertse() {
        TypedQuery<RentProperty> query = em.createNamedQuery("findAllRentPropertise", RentProperty.class);
        return query.getResultList();
    }

    public RentProperty findById(Long id) {
        RentProperty property = em.find(RentProperty.class, id);
        if (property == null) {
            throw new EntityNotFoundException("Can't find RentalProperty for ID "
                + id);
        }
        return property;
    }
    
}
