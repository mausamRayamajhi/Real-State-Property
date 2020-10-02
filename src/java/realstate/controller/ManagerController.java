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
import realstate.model.EJB.ManagerEJB;
import realstate.model.Manager;

/**
 * This is comment by bikash
 * This is a comment by Prativa
 * @author Mausam Rayamajhi
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class ManagerController {

    @EJB
    private ManagerEJB managerEJB;
    private Manager manager = new Manager();
    private List<Manager> managerList = new ArrayList<Manager>();

    /**
     * doCreateManager() method create new manager
     *
     * @return xhtml page containing data of manager list
     */
    public String doCreateManager() {
//        ArrayList<RentProperty> rent = new ArrayList<>();
//       
//        rent.add(new RentProperty(1l,15,new Address(1, "asdf", "asdf", 3, "asf"),"sdf","asdf",2,23,true));
//manager.setRentPropertys(rent);
        manager = managerEJB.createManager(manager);

        managerList = managerEJB.findManagers();

        return "listManager.xhtml";
    }

    public String viewManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
       System.out.print("ID = "+params.get("id"));
        manager.toString();
        manager.setId(Long.parseLong(params.get("id")));
        manager = managerEJB.findById(manager.getId());
        return "viewManager.xhtml";

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
       
//  FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//       System.out.print("ID = "+params.get("id"));
//       manager.setFirstName(params.get("firstName"));
//          manager.setLastName(params.get("lastName"));

         managerList = managerEJB.searchManager(manager.getFirstName(), manager.getLastName());
         System.out.print("search = "+managerList.toString());
         return "searchlistManager.xhtml";
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

    
}
