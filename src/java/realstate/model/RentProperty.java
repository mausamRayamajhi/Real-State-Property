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
public class RentProperty extends Property {
    
    @Column(nullable = false)
     private double salePrice;
     private boolean isFurnished;
     
//      @OneToMany(cascade = CascadeType.ALL, mappedBy = "rentProperty")
//     @JoinTable(name = "Rent_Property_Allocation")
//     private List<Allocation> rentPropertys;
//     
  
     
    
    public RentProperty() {
    }

    public RentProperty(Long id,double salePrice, Address address, String description, String type, int bedroom, int bathroom,boolean isFurnished) {
        super(id, address, description, type, bedroom, bathroom);
        this.salePrice = salePrice;
        this.isFurnished = isFurnished;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isIsFurnished() {
        return isFurnished;
    }

    public void setIsFurnished(boolean isFurnished) {
        this.isFurnished = isFurnished;
    }

    @Override
    public String toString() {
        return "RentProperty{" + "salePrice=" + salePrice + ", isFurnished=" + isFurnished + '}';
    }
    
    

    
     
     
}
