/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import realstate.model.Address;
import realstate.model.EJB.RentPropertyEJB;

import realstate.model.RentProperty;


/**
 *
 * @author Mausam Rayamajhi
 */
@ManagedBean
@RequestScoped
@ViewScoped
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
    
  

    public RentProperty getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(RentProperty rentProperty) {
        this.rentProperty = rentProperty;
    }

    public List<RentProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<RentProperty> propertyList) {
        this.propertyList = propertyList;
    }
   public Address getAddress() {
           return address;
       }

    
    
   public String viewRentProperty() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        System.out.print("ID = "+params.get("id"));
        address.getStreetNumber();
        address.getStreetName();
        address.getCity();
        address.getPostCode();
        address.getCountry();
        rentProperty.getAddress();
        rentProperty.toString();
        rentProperty.setId(Long.parseLong(params.get("id")));
        rentProperty = rentPropertyEJB.findById(rentProperty.getId());
        return "viewRentalProperty.xhtml";

    }
   
      public String searchRentProperty() {
       
//  FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//       System.out.print("ID = "+params.get("id"));
//       manager.setFirstName(params.get("firstName"));
//          manager.setLastName(params.get("lastName"));

        rentProperty = rentPropertyEJB.findById(rentProperty.getId());
         System.out.print("search = "+rentProperty.toString());
         
         return "viewRentalProperty.xhtml";
    }
}
