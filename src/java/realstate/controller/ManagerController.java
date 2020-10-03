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
