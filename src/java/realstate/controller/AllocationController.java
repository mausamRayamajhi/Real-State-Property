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
import javax.faces.bean.ViewScoped;
import realstate.model.Allocation;
import realstate.model.EJB.AllocationEJB;


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
    private List<Allocation> allocationList = new ArrayList();
    //private List<Manager> managerList = new ArrayList<Manager>();
  
    
    
    public String doCreateAllocation() {
//        ArrayList<RentProperty> rent = new ArrayList<>();
//       
//        rent.add(new RentProperty(1l,15,new Address(1, "asdf", "asdf", 3, "asf"),"sdf","asdf",2,23,true));
//manager.setRentPropertys(rent);
        allocation = allocationEJB.createAllocation(allocation);

        allocationList = allocationEJB.findAllAllocation();

        return "listAllocation.xhtml";
    }
    
     public List<Allocation> deleteAllocations() {
        return allocationList;
       

    }
     
     public String searchAllocation() {
       
//  FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//       System.out.print("ID = "+params.get("id"));
//       manager.setFirstName(params.get("firstName"));
//          manager.setLastName(params.get("lastName"));

        allocation =  allocationEJB.findById(allocation.getId());
         System.out.print("search = "+allocation.toString());
         
         System.out.print("search = "+allocationList.toString());
         
         return "searchListAllocation.xhtml";
    }

     
     public void getAllocationList(){
     
     }

    public void setAllocationEJB(AllocationEJB allocationEJB) {
        this.allocationEJB = allocationEJB;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    public void setAllocationList(List<Allocation> allocationList) {
        this.allocationList = allocationList;
    }
}
