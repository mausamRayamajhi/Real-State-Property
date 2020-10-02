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
import realstate.model.Address;
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
    private RentPropertyEJB rentPropertyEJB;
    private RentProperty rentProperty = new RentProperty();
    private Address address = new Address();
    private List<RentProperty> propertyList = new ArrayList<>();

    public String createRentProperty() {
              rentProperty.setAddress(address);
        rentProperty = rentPropertyEJB.createRentProperty(rentProperty);

        propertyList = rentPropertyEJB.findRentPropertse();

        return "listRentProperty.xhtml";
    }
    
    public RentProperty getManagerById() {
        rentProperty = rentPropertyEJB.findById(rentProperty.getId());
        return rentProperty;
    }
    
    public List<RentProperty> getRentPropertyList() {
        return rentPropertyEJB.findRentPropertse();
    }
    
    public RentProperty getProperty() {
        return rentProperty;
    }

    public void setProperty(RentProperty rentProperty) {
        this.rentProperty = rentProperty;
    }

    public List<RentProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<RentProperty> propertyList) {
        this.propertyList = propertyList;
    }
}
