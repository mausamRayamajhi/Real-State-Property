/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import realstate.model.EJB.ManagerEJB;
import realstate.model.EJB.RentPropertyEJB;
import realstate.model.EJB.SalePropertyEJB;
import realstate.model.Manager;
import realstate.model.RentProperty;
import realstate.model.SaleProperty;

/**
 * This is comment by bikash This is a comment by Prativa
 *
 * @author Mausam Rayamajhi
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class ManagerController {

    @EJB
    private ManagerEJB managerEJB;


    
//    @EJB
//    private RentPropertyEJB rentPropertyEJB;
//
//    @EJB
//    private SalePropertyEJB salePropertyEJB;

    
     @EJB
    private AllocationEJB allocationEJB;
     
    private Manager manager = new Manager();
    private List<Manager> managerList = new ArrayList<Manager>();
    private List<Manager> managerFoundList = new ArrayList<Manager>();
      private List<Allocation> allocationList = new ArrayList();

    /**
     * doCreateManager() method create new manager
     *
     * @return xhtml page containing data of manager list
     */
    public String doCreateManager() {

        manager = managerEJB.createManager(manager);

        managerList = managerEJB.findManagers();

//        Manager m1 = new Manager("Mausam ", "Rayamajhi", 1234578, 15624987, "mausam45@gmail.com", 0l);
//        Manager m2 = new Manager("Prativa ", "Shah", 757527, 1562456987, "Prativa@gmail.com", 0l);
//        Manager m3 = new Manager("Bikash ", "Shah", 12345678, 1562456987, "Bikash@gmail.com", 0l);
//        Manager m4 = new Manager("Nabin ", "khatri", 12345678, 1562456987, "Nabin@gmail.com", 0l);
//        Manager m5 = new Manager("Lonen ", "sky", 12345678, 1562456987, "Lonen@gmail.com", 0l);
//
//        Address a1 = new Address(100, "Taylors road", "Melbourne", 3038, "Australia");
//        Address a2 = new Address(200, "Elizabet st", "Sydney", 3058, "Australia");
//        Address a3 = new Address(300, "Footscray road", "Perth", 3098, "Australia");
//
//        RentProperty r1 = new RentProperty(1l, 1300l, true, "This is long description", "Apartment", 12, 23, a1);
//        RentProperty r2 = new RentProperty(2l, 1250l, false, "This is long description", "Apartment", 1212, 21233, a2);
//        RentProperty r3 = new RentProperty(3l, 1290l, true, "This is long description", "House", 1002, 2323, a3);
//
//        SaleProperty s1 = new SaleProperty(123l, 1l, "This is desc", "House", 12, 23, a3);
//        SaleProperty s2 = new SaleProperty(123234l, 1l, "This is desc", "Apartment", 142, 223, a1);
//        SaleProperty s3 = new SaleProperty(12367l, 1l, "This is desc", "House", 2, 23, a2);
//
//        Allocation al1 = new Allocation(1l, m1, r1, s1, LocalDateTime.now());
//        Allocation al2 = new Allocation(2l, m2, r2, s2, LocalDateTime.now());
//        Allocation al3 = new Allocation(3l, m3, r3, s3, LocalDateTime.now());
//
//        managerEJB.createManager(m1);
//        managerEJB.createManager(m2);
//        managerEJB.createManager(m3);
//        managerEJB.createManager(m4);
//        managerEJB.createManager(m5);
//        rentPropertyEJB.createRentProperty(r1);
//        rentPropertyEJB.createRentProperty(r2);
//        rentPropertyEJB.createRentProperty(r3);
//
//        salePropertyEJB.createSaleProperty(s1);
//        salePropertyEJB.createSaleProperty(s2);
//        salePropertyEJB.createSaleProperty(s3);
//
//        allocationEJB.createAllocation(al1);
//        allocationEJB.createAllocation(al2);
//        allocationEJB.createAllocation(al3);
        return "listManager.xhtml";
    }

    public String viewManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        System.out.print("ID = " + params.get("id"));
        manager.toString();
        manager.setId(Long.parseLong(params.get("id")));
        manager = managerEJB.findById(manager.getId());
        return "viewManager.xhtml";

    }

    public String viewFoundManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        System.out.print("ID = " + params.get("id"));
        manager.toString();
        // manager.setId(Long.parseLong(params.get("id")));
        manager.setFirstName(params.get("firstName"));
        manager.setLastName(params.get("lastName"));
        manager = (Manager) managerEJB.searchManager(manager.getFirstName(), manager.getLastName());
        getAllocationList();
        return "viewManager.xhtml";

    }

    public List<Allocation> getAllocationList() {
        return allocationList = allocationEJB.findByManagerId(manager.getId());
    }
    
    /**
     * getManager() method return single manager
     *
     * @return Manager
     */
    public Manager getManager() {
        return manager;
    }
    
    

    /**
     * getManagerById() method return manager by ID
     *
     * @return Manager
     */
    public void getManagerById() {
        manager = managerEJB.findById(manager.getId());

    }

    /**
     * searchManager() method search manager by first name and last name
     *
     * @return single Manager object
     */
    public String searchManager() {
        managerFoundList = managerEJB.searchManager(manager.getFirstName(), manager.getLastName());
        System.out.print("search = " + managerFoundList.toString());

        return "searchListManager.xhtml";
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * getManagerList() gets all managerlist from db
     *
     * @return List of managers
     */
    public List<Manager> getManagerList() {
        return managerEJB.findManagers();
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }

    public List<Manager> getManagerFoundList() {
        return managerFoundList;
    }

}
