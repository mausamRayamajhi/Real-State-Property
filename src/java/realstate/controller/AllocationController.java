/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import realstate.model.Address;
import realstate.model.Allocation;
import realstate.model.EJB.AllocationEJB;
import realstate.model.Manager;
import realstate.model.RentProperty;
import realstate.model.SaleProperty;

/**
 *
 * @author Prativa Shah
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class AllocationController {

    @EJB
    private AllocationEJB allocationEJB;
    private Allocation allocation = new Allocation();
    private Manager manager = new Manager();
    private RentProperty rentProperty = new RentProperty();
    private SaleProperty saleProperty = new SaleProperty();
    private List<Allocation> allocationList = new ArrayList();
    private Address  address = new Address();
    //private List<Manager> managerList = new ArrayList<Manager>();

    public String doCreateAllocation() {
//        ArrayList<RentProperty> rent = new ArrayList<>();
//       
//        rent.add(new RentProperty(1l,15,new Address(1, "asdf", "asdf", 3, "asf"),"sdf","asdf",2,23,true));
//manager.setRentPropertys(rent);
rentProperty.setAddress(address);
saleProperty.setAddress(address);
        allocation.setManager(manager);
        allocation.setSaleProperty(saleProperty);
        allocation.setRentProperty(rentProperty);
        allocation.setDate(LocalDateTime.now());
        
        System.out.println("Allocation = "+allocation.toString());
 allocationEJB.createAllocation(allocation);

//        allocationList = allocationEJB.findAllAllocation();
        return "listAllocation.xhtml";
    }

    public void deleteAllocations() {
         FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
       
        allocation.setId(Long.parseLong(params.get("id")));
         allocationEJB.delete(allocation);

    }

    public String searchAllocation() {

//  FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//       System.out.print("ID = "+params.get("id"));
//       manager.setFirstName(params.get("firstName"));
//          manager.setLastName(params.get("lastName"));
allocationList.clear();
        allocation = allocationEJB.findById(allocation.getId());
        allocationList.add(allocation);
        System.out.print("search = " + allocation.toString());

   

        return "allocationSearch.xhtml";
    }

    public List<Allocation> getAllocationList() {
        return allocationList = allocationEJB.findAllAllocation();
    }

  

    

    public void setAllocationList(List<Allocation> allocationList) {
        this.allocationList = allocationList;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public RentProperty getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(RentProperty rentProperty) {
        this.rentProperty = rentProperty;
    }

    public SaleProperty getSaleProperty() {
        return saleProperty;
    }

    public void setSaleProperty(SaleProperty saleProperty) {
        this.saleProperty = saleProperty;
    }

}
