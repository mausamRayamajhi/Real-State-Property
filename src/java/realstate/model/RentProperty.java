/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mausam Rayamajhi
 */
@Entity
@Table(name = "Rent_Property")
@NamedQueries({
    @NamedQuery(name = "findAllRentPropertise", query = "SELECT m FROM RentProperty m"),})
public class RentProperty  extends Property{
    
    @Column(nullable = false)
     private double weekly_Rent;
     private boolean isFurnished;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "rentProperty")
     private List<Allocation> allocations;
//     
  
     
    
    public RentProperty() {
    }

    public RentProperty(Long id,double weeklyRent, boolean isFurnished,String description, String type, int bedroom, int bathroom, Address addres) {
        super(id,  description,  type,  bedroom,  bathroom,  addres);
        this.weekly_Rent = weeklyRent;
        this.isFurnished = isFurnished;
    }

    public double getWeeklyRent() {
        return weekly_Rent;
    }

    public void setWeeklyRent(double weeklyRent) {
        this.weekly_Rent = weeklyRent;
    }

    public boolean isIsFurnished() {
        return isFurnished;
    }

    public void setIsFurnished(boolean isFurnished) {
        this.isFurnished = isFurnished;
    }

    @Override
    public String toString() {
        return "RentProperty{" + "weeklyRent=" + weekly_Rent + ", isFurnished=" + isFurnished + '}';
    }
    
    

    
     
     
}
