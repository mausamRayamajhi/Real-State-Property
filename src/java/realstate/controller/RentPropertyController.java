/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import realstate.model.EJB.RentPropertyEJB;
import realstate.model.EJB.SalePropertyEJB;
import realstate.model.RentProperty;
import realstate.model.SaleProperty;

/**
 *
 * @author Mausam Rayamajhi
 */
@ManagedBean
@RequestScoped
public class RentPropertyController {
       @EJB
    private RentPropertyEJB eJB;
    private RentProperty property = new RentProperty();
    private List<RentProperty> propertyList = new ArrayList<RentProperty>();

    public String createRentProperty() {
        property = eJB.createRentProperty(property);

        propertyList = eJB.findRentPropertse();

        return "listRentProperty.xhtml";
    }
    
    public RentProperty getManagerById() {
        property = eJB.findById(property.getId());
        return property;
    }
    
    public List<RentProperty> getRentPropertyList() {
        return eJB.findRentPropertse();
    }
}
