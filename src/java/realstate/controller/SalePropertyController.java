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
import realstate.model.EJB.SalePropertyEJB;
import realstate.model.Manager;
import realstate.model.SaleProperty;

/**
 *
 * @author Mausam Rayamajhi
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class SalePropertyController {

    @EJB
    private SalePropertyEJB salePropertyEJB;
    private SaleProperty saleProperty = new SaleProperty();
    private Address address = new Address();
    private List<SaleProperty> salePropertyList = new ArrayList<SaleProperty>();


    public String doCreateSaleProperty() {
        System.out.println("DATA = "+saleProperty.toString());
            saleProperty.setAddress(address);
        saleProperty = salePropertyEJB.createSaleProperty(saleProperty);

        salePropertyList = salePropertyEJB.findSalePropertse();

        return "listSaleProperty.xhtml";
    }
    
    public SaleProperty getManagerById() {
        saleProperty = salePropertyEJB.findById(saleProperty.getId());
        return saleProperty;
    }
    
    public List<SaleProperty> getSalePropertyList() {
        return salePropertyEJB.findSalePropertse();
    }
    
    public SaleProperty getSaleProperty() {
           return saleProperty;
       }
    public Address getAddress() {
           return address;
       }

    

    public void setSaleProperty(SaleProperty saleProperty) {
        this.saleProperty = saleProperty;
    }

    public void setSalePropertyList(List<SaleProperty> salePropertyList) {
        this.salePropertyList = salePropertyList;
    }

   

    public void setProperty(SaleProperty saleProperty) {
        this.saleProperty = saleProperty;
    }
   
 
   public String viewSaleProperty() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        System.out.print("ID = "+params.get("id"));
        address.getStreetNumber();
        address.getStreetName();
        address.getCity();
        address.getPostCode();
        address.getCountry();
        saleProperty.getAddress();
        saleProperty.toString();
        saleProperty.setId(Long.parseLong(params.get("id")));
        saleProperty = salePropertyEJB.findById(saleProperty.getId());
        return "viewSaleProperty.xhtml";

    }
   
      public String searchSaleProperty() {
       
//  FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//       System.out.print("ID = "+params.get("id"));
//       manager.setFirstName(params.get("firstName"));
//          manager.setLastName(params.get("lastName"));

        saleProperty = salePropertyEJB.findById(saleProperty.getId());
         System.out.print("search = "+saleProperty.toString());
         
         return "viewSaleProperty.xhtml";
    }

    
}
