/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@NamedQueries({
    @NamedQuery(name = "findAllSalePropertise", query = "SELECT m FROM SaleProperty m"),
    
})
public class SaleProperty extends Property {

    @Column(nullable = false)
    private double salePrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleProperty")
     private List<Allocation> allocations;

    public SaleProperty() {
//        address = new Address();
    }

    public SaleProperty( double salePrice,Long id,String description, String type, int bedroom, int bathroom,Address address) {
//        super(id, description, type, bedroom, bathroom);
        //this.address = address;
         super(id , description,  type,  bedroom,  bathroom,address);
        this.salePrice = salePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "SaleProperty{" + "salePrice=" + salePrice + '}';
    }

    @Override
     public Address getAddress() {
       return address;
    }

    @Override
   public void setAddress(Address address) {
       this.address = address;
    }

}
