/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w8p1;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mausam Rayamajhi
 */
@Entity
@Table(name = "Rent_Property")
public class RentProperty extends Property {
    
     private double salePrice;
     private boolean isFurnished;
     
    
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
