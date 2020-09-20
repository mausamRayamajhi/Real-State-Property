/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w8p1;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mausam Rayamajhi
 */

@Entity
@Table(name = "Sale_Property")
public class SaleProperty extends Property {
    private double salePrice;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleProperty",targetEntity=w8p1.SaleProperty.class)
//     private Manager manager;
    
    public SaleProperty() {
    }

    public SaleProperty(Long id,double salePrice, Address address, String description, String type, int bedroom, int bathroom) {
        super(id, address, description, type, bedroom, bathroom);
        this.salePrice=salePrice;
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
    
    
    
}
