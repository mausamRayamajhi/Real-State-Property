/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
