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
import realstate.model.EJB.ManagerEJB;
import realstate.model.Manager;

/**
 *This is comment by bikash
 * @author Mausam Rayamajhi
 */
@ManagedBean
@RequestScoped
public class ManagerController {
    
    @EJB
    private ManagerEJB managerEJB;
    private Manager manager =  new Manager();
    private List<Manager> managerList = new ArrayList<Manager>();
    
    
     public String doCreateManager() {
        manager = managerEJB.createManager(manager);
        managerList = managerEJB.findManagers();
        return "listManager.xhtml";
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }
     
     
}
