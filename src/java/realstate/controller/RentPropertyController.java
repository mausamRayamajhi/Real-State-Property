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
import realstate.model.EJB.RentPropertyEJB;

import realstate.model.RentProperty;
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
    private RentPropertyEJB salePropertyEJB;
    private RentProperty saleProperty = new RentProperty();
    private Address address = new Address();
    private List<RentProperty> salePropertyList = new ArrayList<RentProperty>();

    public String doCreateRentProperty() {
        System.out.println("DATA = " + saleProperty.toString());
        saleProperty.setAddress(address);
        saleProperty = salePropertyEJB.createRentProperty(saleProperty);

        salePropertyList = salePropertyEJB.findRentPropertse();

        return "listRentProperty.xhtml";
    }

//    public RentProperty getManagerById() {
////        saleProperty = salePropertyEJB.findById(saleProperty.getId());
//        return saleProperty;
//    }
    public List<RentProperty> getRentPropertyList() {
        return salePropertyEJB.findRentPropertse();
    }

    public RentProperty getRentProperty() {

        return saleProperty;
    }

    public Address getAddress() {
        return address;
    }

    public void setRentProperty(RentProperty saleProperty) {
        this.saleProperty = saleProperty;
    }

    public void setRentPropertyList(List<RentProperty> salePropertyList) {
        this.salePropertyList = salePropertyList;
    }

    public void setProperty(RentProperty saleProperty) {
        this.saleProperty = saleProperty;
    }

    public String viewRentProperty() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        saleProperty = salePropertyEJB.findById(Long.parseLong(params.get("id")));
        return "viewRentalProperty.xhtml";
    }

    public String searchRentProperty() {

        saleProperty = salePropertyEJB.findById(saleProperty.getId());
        System.out.print("search = " + saleProperty.toString());

        return "viewRentalProperty.xhtml";
    }

}
