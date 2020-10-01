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
@Table(name = "Sale_Property")
@NamedQueries({
    @NamedQuery(name = "findAllSalePropertise", query = "SELECT m FROM SaleProperty m"),})
public class SaleProperty extends Property {

    @Column(nullable = false)
    private double salePrice;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleProperty")
//    @JoinTable(name = "Sales_Property_Allocation")
//    private List<Allocation> salePropertys;

    public SaleProperty() {
    }

    public SaleProperty(Long id, double salePrice, Address address, String description, String type, int bedroom, int bathroom) {
        super(id, address, description, type, bedroom, bathroom);
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

}
