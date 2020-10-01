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
import realstate.model.EJB.SalePropertyEJB;
import realstate.model.Manager;
import realstate.model.SaleProperty;

/**
 *
 * @author Mausam Rayamajhi
 */
@ManagedBean
@RequestScoped
public class SalePropertyController {

    @EJB
    private SalePropertyEJB salePropertyEJB;
    private SaleProperty property = new SaleProperty();

    private List<SaleProperty> salePropertyList = new ArrayList<>();


    public String doCreateSaleProperty() {
        System.out.println("DATA = "+property.toString());
  
        property = salePropertyEJB.createSaleProperty(property);

        salePropertyList = salePropertyEJB.findSalePropertse();

        return "listSaleProperty.xhtml";
    }
    
    public SaleProperty getManagerById() {
        property = salePropertyEJB.findById(property.getId());
        return property;
    }
    
    public List<SaleProperty> getSalePropertyList() {
        return salePropertyEJB.findSalePropertse();
    }
    
    

    public void setSaleProperty(SaleProperty saleProperty) {
        this.property = saleProperty;
    }

    public void setSalePropertyList(List<SaleProperty> salePropertyList) {
        this.salePropertyList = salePropertyList;
    }

    public SaleProperty getProperty() {
        return property;
    }

    public void setProperty(SaleProperty property) {
        this.property = property;
    }
   
 

   
    
}
