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
import realstate.model.Manager;
import realstate.model.SaleProperty;

/**
 *
 * @author Mausam Rayamajhi
 */
@Stateful
public class SalePropertyEJB {

    @PersistenceContext(unitName = "W8P1PU")
    private EntityManager em;

    public SaleProperty createSaleProperty(SaleProperty saleProperty) {
        em.persist(saleProperty);
        return saleProperty;
    }
    
    public List<SaleProperty> findSalePropertse() {
        TypedQuery<SaleProperty> query = em.createNamedQuery("findAllSalePropertise", SaleProperty.class);
        return query.getResultList();
    }
    
     public SaleProperty findById(Long id) {
        SaleProperty property = em.find(SaleProperty.class, id);
        if (property == null) {
            throw new EntityNotFoundException("Can't find SaleProperty for ID "
                + id);
        }
        return property;
    }
     
    
}
